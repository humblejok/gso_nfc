package org.gso.network.messaging.gui;

import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import org.gso.network.messaging.gui.resources.ResourcesProvider;

public class AccountSetupWindow extends JFrame implements WindowListener {
	
	public AccountSetupWindow() {
		super("Accounts setup");
		this.setSize(300, 500);
		this.setAlwaysOnTop(true);
		this.setLayout(new GridLayout(1,1));
		this.addWindowListener(this);
		this.setIconImage(ResourcesProvider.getInstance().getImage("bubble.png"));
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
		this.setVisible(false);
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
