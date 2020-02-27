package main.java;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("192.168.238.1",8000);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String message = reader.readLine();
        System.out.println(message);

        clientSocket.close();

    }
}
