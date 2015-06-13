package com.iuce.protocol;

import java.net.DatagramSocket;

import com.iuce.protocol.MessagePacket;
import com.iuce.protocol.MessageSocket;

public class SenderUDP {

	private DatagramSocket socket;

	public SenderUDP(DatagramSocket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	public void send(String code, String fromAddress, String content) {
		MessagePacket mpacket = new MessagePacket(code, fromAddress, content);
		MessageSocket msocket = new MessageSocket(socket, mpacket);
		msocket.send();
	}

}
