package com.iuce.thread;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import javax.imageio.ImageIO;

import com.iuce.constant.Constants;
import com.iuce.panel.FacePanel;

public class ThreadReciever extends Thread {

	private BufferedImage bufImageFromServer;
	DatagramSocket socket;
	FacePanel panel;

	public ThreadReciever(DatagramSocket socket, FacePanel panel) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		bufImageFromServer = null;
		this.panel = panel;
	}

	public BufferedImage getBufImageFromServer() {
		return bufImageFromServer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (true) {
			byte[] byteImageFromServer = new byte[65000];
			DatagramPacket packet = new DatagramPacket(byteImageFromServer,
					byteImageFromServer.length, Constants.getIP_ADDRESS(),
					Constants.PORT_SERVER);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] byteOnlyImage = packet.getData();
			System.out.println("gelen image boyut: " + byteOnlyImage.length);
			try {
				this.bufImageFromServer = ImageIO
						.read(new ByteArrayInputStream(byteOnlyImage));
				panel.setImage(bufImageFromServer);
				panel.repaint();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
