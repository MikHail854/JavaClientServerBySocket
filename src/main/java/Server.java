package main.java;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int count = 0;
        ServerSocket serverSocket = new ServerSocket(8000);

        while (true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted " + (++count));
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            /*writer.write("HTTP/1.0 200 OK\n + " +
                    "Content-type: text/html\n" +
                    "\n" +
                    "<h1>Hello JAVA " + count + "</h1>\n");*/
            writer.write("You are client #" + count + "\n");
            writer.flush();
            writer.close();

            clientSocket.close();
        }
        //serverSocket.close();
    }
}
