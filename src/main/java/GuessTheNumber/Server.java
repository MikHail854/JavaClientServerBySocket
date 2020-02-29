package main.java.GuessTheNumber;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("I made a number from 1 to 100. Guess!");
        int random = (int) (Math.random() * 100);
        System.out.println(random);
        String response = "Error";

        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            Socket clientSocket = serverSocket.accept();

            OutputStreamWriter writer = new OutputStreamWriter(
                    clientSocket.getOutputStream());

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            Thread.sleep(3000);
            int helper = reader.read();
            if (random == helper) {
                response = "Congratulations! You guessed the number\n" +
                        "I made a different number! Try to guess it now\n";
                random = (int) (Math.random() * 100);
            } else if (random < helper) {
                response = "smaller\n";
            } else if (random > helper) {
                response = "more\n";
            }
            writer.write(response);
            writer.flush();
            writer.close();
            reader.close();

            clientSocket.close();

        }
    }

}
