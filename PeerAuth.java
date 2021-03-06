﻿package jChat;

import java.io.BufferedReader;
import java.io.IOException;



public class PeerAuth implements JChatAuthenticator
{
	
	private PeerSocket jcs;

    public PeerAuth(PeerSocket jcs) 
    {
        this.jcs=jcs;
    }
    
    public boolean connect (){
    	return jcs.connect();
    }

	@Override
	public void sendMessage(String message) {
		jcs.sendMessage(message);
		
	}

	@Override
	public void stopConnection() {
		// TODO Auto-generated method stub
		
	}
	
	public BufferedReader getReader (){
		return jcs.getReader();
	}

	@Override
	public void accept(APeer p) throws IOException {
		// TODO Auto-generated method stub
		
	}


}
