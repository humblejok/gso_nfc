package org.gso.network.messaging.gui.element;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.gso.network.messaging.client.SimpleRMQClient;

public class InputComponent extends JPanel implements ActionListener {
	
	private SimpleRMQClient client;
	
	private JTextArea inputZone = new JTextArea();
	private JButton sendButton = new JButton("Send");
	
	public InputComponent(SimpleRMQClient client) {
		super(new BorderLayout());
		
		this.client = client;
		this.initializeListeners();
		
		this.add(inputZone, BorderLayout.CENTER);
		this.add(sendButton, BorderLayout.EAST);
	}
	
	protected void initializeListeners() {
		sendButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Send")) {
			this.client.publishMessage("python", inputZone.getText());
			inputZone.setText("");
		}
	}
}
