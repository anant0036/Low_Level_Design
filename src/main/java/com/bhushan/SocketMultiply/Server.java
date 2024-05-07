package com.bhushan.SocketMultiply;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            System.out.println("Server is running");
            server = new ServerSocket(5555);
            server.setReuseAddress(true);

            while(true) {
                System.out.println("We are checking ...");
                Socket client = server.accept();
                System.out.println("New client connection " + client.getInetAddress().getHostAddress());

                ClientHandler clientSocket = new ClientHandler(client);
                new Thread(clientSocket).start();
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
