package com.bhushan.SocketMultiply;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 5555)) {

            //Writing to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            //Reading from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner sc = new Scanner(System.in);
            String line = null;

            while(!"EXIT".equalsIgnoreCase(line)) {
                line = sc.nextLine();
                out.println(line);
                out.flush();
                System.out.println("Server replayed " + in.readLine());
            }
            sc.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
