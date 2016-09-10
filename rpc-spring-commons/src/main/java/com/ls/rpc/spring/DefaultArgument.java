package com.ls.rpc.spring;

import java.util.HashMap;
import java.util.Map;

public class DefaultArgument implements Argument{

	private String callerName;
	private Map<String, Object> params = new HashMap<String, Object>();
	
	public DefaultArgument(){
		
	}
	
	public String getCallerName() {
		return this.callerName;
	}

	public void setCallerName(String name) {
		this.callerName = name;
	}

	public void put(String name, Object value) {
		params.put(name, value);
	}

	public String getStrParam(String name) {
		return (String) params.get(name);
	}

}
