package com.ls.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 1233);
		BufferedInputStream is = new BufferedInputStream(s.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println(br.readLine());
	}
}
