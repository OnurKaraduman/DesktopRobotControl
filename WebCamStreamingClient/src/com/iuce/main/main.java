package com.iuce.main;

import javax.swing.JFrame;
import com.iuce.panel.LoginPanel;

public class main {

	private static JFrame jframeImage;

	public static void main(String[] args) {
		jframeImage = new JFrame();
		jframeImage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframeImage.setSize(400, 400);
		jframeImage.setVisible(true);
		System.out.println("maindeyiz");
		LoginPanel lPanel = new LoginPanel();
		lPanel.setVisible(true);
		jframeImage.setContentPane(lPanel);
	}	
}
