package org.gso.network.messaging.gui;

import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import org.gso.network.messaging.client.SimpleRMQClient;
import org.gso.network.messaging.gui.element.InputComponent;
import org.gso.network.messaging.gui.element.OutputComponent;
import org.gso.network.messaging.gui.resources.ResourcesProvider;

public class ConversationWindow extends JFrame implements WindowListener {
	
	private JSplitPane verticalPanel;
	private SimpleRMQClient client;
	
	public ConversationWindow(SimpleRMQClient client) {
		super("Conversing...");
		this.client = client;
		this.setSize(300, 500);
		this.setAlwaysOnTop(false);
		this.setLayout(new GridLayout(1,1));
		verticalPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new OutputComponent(client) , new InputComponent(client));
		verticalPanel.setDividerLocation(350);
		this.add(verticalPanel);
		this.setIconImage(ResourcesProvider.getInstance().getImage("bubble.png"));
		this.addWindowListener(this);
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

}
