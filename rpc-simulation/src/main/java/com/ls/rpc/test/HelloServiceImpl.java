package com.ls.rpc.test;

public class HelloServiceImpl implements HelloService{

	public String say(String name) {
		
		return "hello " + name;
	}

}
