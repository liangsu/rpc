package com.ls.rpc.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcFramework {

	/**
	 * 暴露服务
	 * @param service
	 * @param port
	 */
	public static void export(final Object service, int port){
		try {
			ServerSocket ss = new ServerSocket(port);
			
			while(true){
				final Socket s = ss.accept();
				
				new Thread(new Runnable() {
					public void run() {
						try {
							ObjectInputStream input = new ObjectInputStream(s.getInputStream());
							try {
								String methodName = input.readUTF();
								Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
								Object[] arguments = (Object[]) input.readObject();
								
								Method m = service.getClass().getMethod(methodName, parameterTypes);
								Object result = m.invoke(service, arguments);
								
								ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
								try {
									os.writeObject(result);
									os.flush();
								} catch (IOException e) {
									e.printStackTrace();
								}finally {
									os.close();
								}
							} catch (Exception e) {
								e.printStackTrace();
							}finally {
								input.close();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 获取远程服务对象
	 * @param interfaceClass
	 * @param host
	 * @param port
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T>T refer(Class<T> interfaceClass, final String host, final int port){
		
		return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Socket s = new Socket(host, port);
				ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
				
				os.writeUTF(method.getName());
				os.writeObject(method.getParameterTypes());
				os.writeObject(args);
				os.flush();
				
				ObjectInputStream input = new ObjectInputStream(s.getInputStream());
				Object result = input.readObject();
				
				if (result instanceof Throwable) {
					throw (Throwable)result;
				}
				
				return result;
			}
		});
	}
	
}
