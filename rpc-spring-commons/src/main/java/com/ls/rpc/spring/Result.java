package com.ls.rpc.spring;

import java.io.Serializable;

public class Result implements Serializable{

	private Object result;
	
	public Object getResult() {
		return result;
	}

	public void setResult(Object value) {
		this.result = (String) value;
	}
	
}
