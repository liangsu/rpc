package com.ls.rpc.test;

/**
 * 服务消费者
 * @author warhorse
 *
 */
public class RpcConsumer {

	public static void main(String[] args) {
		HelloService helloService = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
		for(int i = 0; i < 100; i++){
			String word = helloService.say("小明-"+i);
			System.out.println(word);
		}
	}
}
