package com.iuce.protocol;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import com.iuce.constant.Constants;

public class MessageSocket {

	private DatagramSocket dataSocket;
	private MessagePacket mPacket;

	public MessageSocket(DatagramSocket socket, MessagePacket mPacket) {
		this.dataSocket = socket;
		this.mPacket = mPacket;
	}

	public void send() {
		byte[] sendByte = mPacket.toString().getBytes();

		DatagramPacket packet = new DatagramPacket(sendByte, sendByte.length,
				Constants.IP_ADDRESS, Constants.PORT_ADDRESS_SERVER);
		try {
			dataSocket.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() {
		dataSocket.close();
	}

}