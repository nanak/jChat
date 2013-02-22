﻿package jChat;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SrvSocket extends Thread implements JChatSocket
{
	
	private ServerSocket srvS;
	private List<Socket> clients = Collections.synchronizedList(new ArrayList());
	private List<PrintWriter> outgoing = Collections.synchronizedList(new ArrayList());
	private List<BufferedReader> incomming = Collections.synchronizedList(new ArrayList());
	
	public SrvSocket(){
		try {
			srvS = new ServerSocket(1492);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.start();
	}
	
	public void sendMessage (String message){
		for(int i = 0;i < outgoing.size();i++){
			outgoing.get(i).print(message);
			outgoing.get(i).flush();
		}
	}
	
	public List<BufferedReader> getReader (){
		return incomming;
	}
	
	public Socket accept () throws IOException {
		
		return srvS.accept();
		
	}
	
	public void addClient( Socket s) throws IOException{
		
			clients.add(s);
			incomming.add(new BufferedReader(new InputStreamReader(s.getInputStream())));
			outgoing.add( new PrintWriter(s.getOutputStream(), true));
			
	}

	public void stopConnection() {
		// TODO Auto-generated method stub
		
	}
	


}
