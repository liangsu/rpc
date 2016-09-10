package com.ls.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(1233);
		Socket s = ss.accept();
		PrintWriter os = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		os.println("hello world!");
		os.flush();
		s.close();
	}
}
