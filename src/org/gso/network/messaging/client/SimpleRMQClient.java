package org.gso.network.messaging.client;

import java.io.IOException;
import java.util.ArrayList;

import org.gso.network.messaging.gui.element.OutputComponent;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

public class SimpleRMQClient implements Runnable {

	protected String source;
	
	protected ConnectionFactory factory;
	protected Connection connection;
	protected Channel channel;
	
	protected ArrayList<OutputComponent> registeredComponents = new ArrayList<OutputComponent>();
	
	public SimpleRMQClient(String source) {
		this.source = source;
		factory = new ConnectionFactory();
		factory.setHost("192.168.9.93");
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			
			channel.exchangeDeclare("imessage", "direct");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		(new Thread(this)).start();
	}
	
	public void registerDisplay(OutputComponent output) {
		registeredComponents.add(output);
	}
	
	public boolean publishMessage(String target, String message) {
		try {
			channel.basicPublish("imessage", target, null, (this.source + "@" + message).getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public void run() {
		try {
			String queueName = channel.queueDeclare().getQueue();
			channel.queueBind(queueName, "imessage", "java");
			
			QueueingConsumer consumer = new QueueingConsumer(channel);
	        channel.basicConsume(queueName, true, consumer);
	        while (true) {
	        	QueueingConsumer.Delivery delivery = consumer.nextDelivery();
	            String message = new String(delivery.getBody());
	            String routingKey = delivery.getEnvelope().getRoutingKey();
	            
	            for (OutputComponent component : registeredComponents) {
	            	component.append(String.format(message + "%n"));
	            }
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ShutdownSignalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConsumerCancelledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
