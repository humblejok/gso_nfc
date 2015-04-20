package org.gso.network.messaging.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.gso.network.messaging.gui.resources.ResourcesProvider;

public class AccountSetupWindow extends JFrame implements WindowListener {
	
	protected JTextField login = new JTextField("", 16);
	protected JTextField password = new JPasswordField("", 16);
	protected JPanel mainPanel = new JPanel(new MigLayout("wrap 3"));
	
	
	public AccountSetupWindow() {
		super("Accounts setup");
		this.setSize(300, 500);
		this.setAlwaysOnTop(true);
		this.addWindowListener(this);
		this.setIconImage(ResourcesProvider.getInstance().getImage("bubble.png"));
		
		mainPanel.add(new JLabel("Login:"));
		mainPanel.add(login, "span 2");
		mainPanel.add(new JLabel("Password:"));
		mainPanel.add(password, "span 2");
		
		this.add(mainPanel);
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
