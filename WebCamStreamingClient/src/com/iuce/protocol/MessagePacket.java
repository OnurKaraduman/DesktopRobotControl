package com.iuce.protocol;

import com.iuce.constant.Constants;

public class MessagePacket {

	private String code;
	private String fromAddress;
	private String content;

	public MessagePacket(String code, String fromAddress, String content) {
		this.code = code;
		this.fromAddress = fromAddress;
		this.content = content;
	}

	public MessagePacket() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return code + Constants.SPLIT_CHARACTER_LEVEL_1 + fromAddress
				+ Constants.SPLIT_CHARACTER_LEVEL_1 + content;
	}

	public boolean toClass(String s) {
		try {
			String[] variables = s.split(Constants.SPLIT_CHARACTER_LEVEL_1);
			this.code = variables[0];
			this.fromAddress = variables[1];
			this.content = variables[2];
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
