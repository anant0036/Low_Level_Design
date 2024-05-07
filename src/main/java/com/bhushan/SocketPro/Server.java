package com.bhushan.SocketPro;

import java.net.*;
import java.io.*;

public class Server {
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;

    public Server(int port) {
        try {
            server = new ServerSocket(port);

            System.out.println("Server Started");
            System.out.println("Waiting for a client ... ");

            socket = server.accept();
            System.out.println("Client accepted");

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";

            while(!line.equals("OVER")) {
                try {
                    line = in.readUTF();
                    System.out.println(line);
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Closing connection");
            socket.close();
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Server server = new Server(5000);
    }

}
