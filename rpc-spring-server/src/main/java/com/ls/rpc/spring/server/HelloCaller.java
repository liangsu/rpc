package com.ls.rpc.spring.server;

import com.ls.rpc.spring.Argument;
import com.ls.rpc.spring.Caller;
import com.ls.rpc.spring.Result;

public class HelloCaller implements Caller{

	public Result execute(Argument argument) {
		Result result = new Result();
		result.setResult("hello,"+argument.getStrParam("name"));
		return result;
	}

}
