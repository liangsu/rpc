package com.ls.rpc.spring;

import java.io.Serializable;
import java.util.Map;

public interface Argument extends Serializable{
	
	String getCallerName();
	
	void setCallerName(String name);
	
	String getStrParam(String name);
	
	void put(String name, Object value);
}
