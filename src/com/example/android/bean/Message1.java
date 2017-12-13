package com.example.android.bean;

import java.util.Arrays;

public class Message1 {
	
	@Override
	public String toString() {
		return "Message1 [ret_code=" + ret_code + ", list="
				+ Arrays.toString(list) + "]";
	}

	public Message1(String ret_code, ResponeMessage[] list) {
		super();
		this.ret_code = ret_code;
		this.list = list;
	}

	public String getRet_code() {
		return ret_code;
	}

	public void setRet_code(String ret_code) {
		this.ret_code = ret_code;
	}

	public ResponeMessage[] getList() {
		return list;
	}

	public void setList(ResponeMessage[] list) {
		this.list = list;
	}

	private String ret_code;
	
	private ResponeMessage[] list;

}
