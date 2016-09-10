package com.ls.rpc.spring.server;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.ls.rpc.spring.Argument;
import com.ls.rpc.spring.Caller;
import com.ls.rpc.spring.Result;
import com.ls.rpc.spring.Server;

public class DefaultServer implements Server,ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	public Result invoke(Argument argument) {
		Caller caller = (Caller) applicationContext.getBean(argument.getCallerName());
		return caller.execute(argument);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
