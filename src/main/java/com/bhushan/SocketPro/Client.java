package com.bhushan.SocketPro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.*;

public class Client {

    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

   public Client(String address, int port) {
       try {
           System.out.println("About to be Connected");
           socket = new Socket(address, port);
           System.out.println("Connected");
           input = new DataInputStream(System.in);
           out  = new DataOutputStream(socket.getOutputStream());
       } catch(Exception e) {
           System.out.println(e.getLocalizedMessage());
           return;
       }

       String line = "";

       while(!line.equals("OVER")) {
           try {
               line = input.readLine();
               out.writeUTF(line);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }

       try {
           input.close();
           out.close();
           socket.close();
       } catch(Exception e) {
           e.printStackTrace();
       }

   }

    public static void main(String[] args) {
        System.out.println("Client Is Calling");
        Client client = new Client("127.0.0.1", 5000);
    }

}
