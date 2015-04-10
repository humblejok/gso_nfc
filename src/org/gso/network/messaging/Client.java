package org.gso.network.messaging;

import java.awt.AWTException;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.gso.network.messaging.client.SimpleRMQClient;
import org.gso.network.messaging.gui.AccountSetupWindow;
import org.gso.network.messaging.gui.ConversationWindow;
import org.gso.network.messaging.gui.resources.ResourcesProvider;

public class Client implements ActionListener {
	
	private SystemTray tray;
	private TrayIcon trayIcon;
	private AccountSetupWindow accountSetup = new AccountSetupWindow();
	
	public Client() {
		if (SystemTray.isSupported()) {
			tray = SystemTray.getSystemTray();
			trayIcon = new TrayIcon(ResourcesProvider.getInstance().getImage("bubble.png"), "NSA Free Communication", createTrayMenu());
			trayIcon.setImageAutoSize(true);
			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	protected PopupMenu createTrayMenu() {
		PopupMenu popup = new PopupMenu();
		
		Menu configurationMenu = new Menu("Configuration");
		MenuItem userMenu = new MenuItem("Account");
		MenuItem displayMenu = new MenuItem("Display");
		MenuItem exitItem = new MenuItem("Exit");
		configurationMenu.add(userMenu);
		configurationMenu.add(displayMenu);
		
		Menu communicationMenu = new Menu("Communication");
		MenuItem simpleCommMenu = new MenuItem("Simple");
		MenuItem confCommMenu = new MenuItem("Conference");
		communicationMenu.add(simpleCommMenu);
		communicationMenu.add(confCommMenu);
		popup.add(communicationMenu);
		popup.addSeparator();
		popup.add(configurationMenu);
		popup.addSeparator();
		popup.add(exitItem);
		
		communicationMenu.addActionListener(this);
		configurationMenu.addActionListener(this);
		popup.addActionListener(this);
		return popup;
	}
	
	public static void main(String [] argv) {
		Client client = new Client();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Exit")) {
			System.exit(0);
		} else if (ae.getActionCommand().equals("Simple")) {
			ConversationWindow window = new ConversationWindow(new SimpleRMQClient("java"));
			window.setVisible(true);
		} else if (ae.getActionCommand().equals("Conference")) {
			
		} else if (ae.getActionCommand().equals("Account")) {
			accountSetup.setVisible(true);
		} else if (ae.getActionCommand().equals("Display")) {
			
		}
	}
}
