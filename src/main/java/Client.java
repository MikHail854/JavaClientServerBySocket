package main.java;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("192.168.238.1",8000);

        OutputStreamWriter writer =
                new OutputStreamWriter(clientSocket.getOutputStream());

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        writer.write("Get me some information\n");
        writer.flush();

        String response = reader.readLine();
        System.out.println(response);

        writer.close();
        reader.close();
        clientSocket.close();

    }
}
