﻿package jChat;

/**
 * Interface fuer JChatAuthtenticator, legt fest ob eine Verbindung erlaubt ist. 
 * @author Paradox
 *
 */

public interface JChatAuthenticator
{

    
    public void sendMessage (String message);
    public void stopConnection();


}