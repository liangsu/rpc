package com.ls.rpc.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ls.rpc.spring.Argument;
import com.ls.rpc.spring.DefaultArgument;
import com.ls.rpc.spring.Result;
import com.ls.rpc.spring.Server;

public class DefaultClient {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans-client.xml");
		Server server = (Server) ac.getBean("serverProxy");
		System.out.println(server);
		Argument argument = new DefaultArgument();
		argument.setCallerName("helloCaller");
		argument.put("name", "小明");
		Result result = server.invoke(argument);
		System.out.println(result.getResult());
	}
}
