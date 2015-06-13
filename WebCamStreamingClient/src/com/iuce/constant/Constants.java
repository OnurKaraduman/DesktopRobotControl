package com.iuce.constant;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Constants {

	// variables of command
	public static String COMMAND_STOP = "0";
	public static String COMMAND_RIGHT = "1";
	public static String COMMAND_LEFT = "2";
	public static String COMMAND_GO = "3";
	public static String COMMAND_BACK = "4";
	public static String COMMAND_LIGHT = "5";
	public static String LEFT_COMMAND = "turn left";
	public static String RIGHT_COMMAND = "turn right";
	public static String STOP_COMMAND = "stop";
	public static String GO_COMMAND = "go ahead";
	public static String BACK_COMMAND = "back";
	public static boolean control;

	public static int SPEED = 25;
	public static String SPLITSPEEDCHARACTER = ":";

	// variables of socket
	public static int PORT_ADDRESS_SERVER = 9999;
	public static String IP_STRING = "";

	// variables of protocol

	// isaret hiyerarþisi
	/*
	 * /////// bolum cizgizi ::::::: iki nokta _ _ _ _ alttan tire ------- tire
	 */
	public static String SPLIT_CHARACTER_LEVEL_1 = "/";
	public static String SPLIT_CHARACTER_LEVEL_2 = ":";
	public static String SPLIT_CHARACTER_LEVEL_3 = "_";
	public static String SPLIT_CHARACTER_LEVEL_4 = "-";

	public static int PORT_SERVER = 999;
	public static InetAddress IP_ADDRESS = null;

	public static InetAddress getIP_ADDRESS() {
		try {
			return InetAddress.getByName("192.168.2.74");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
