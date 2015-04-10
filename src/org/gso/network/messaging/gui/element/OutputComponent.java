package org.gso.network.messaging.gui.element;

import javax.swing.JTextArea;

import org.gso.network.messaging.client.SimpleRMQClient;

public class OutputComponent extends JTextArea {
	
	public OutputComponent(SimpleRMQClient client) {
		super();
		
		client.registerDisplay(this);
		
		this.setEditable(false);
	}
	
}