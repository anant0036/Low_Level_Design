package com.bhushan.URLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class URLConnectionDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;

            if(urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
            } else {
                System.out.println("Please enter an HTTP URL.. ");
                return;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String urlString = "";
            String current;

            while((current = in.readLine()) != null) {
                System.out.println(current);
                urlString += current;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
