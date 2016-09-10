package com.ls.rpc.test;

/**
 * 服务提供者
 * @author warhorse
 *
 */
public class RpcProvider {

	public static void main(String[] args) {
		HelloService helloWorld = new HelloServiceImpl();
		RpcFramework.export(helloWorld, 1234);
	}
}
