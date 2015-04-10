package org.gso.network.messaging.gui.resources;

import java.awt.Image;
import java.awt.Toolkit;

public class ResourcesProvider {
	
	private static ResourcesProvider instance = null;
	
	private ResourcesProvider() {
	}
	
	public static ResourcesProvider getInstance() {
		if (instance==null) {
			instance = new ResourcesProvider();
		}
		return instance;
	}
	
	public Image getImage(String identifier) {
		return Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bubble.png"));
	}
	
}
