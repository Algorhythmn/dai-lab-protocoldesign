package ch.heig.dai.lab.protocoldesign;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    final String SERVER_ADDRESS = "localhost";
    final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        // Create a new client and run it
        Client client = new Client();
        client.run();
    }

    private void run() {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             var in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             var out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8))) {

            //Simple test, add input for calculation later
            out.write("Client sent a message, did you receive it?\n");
            out.flush();

        } catch (IOException e) {
            System.err.println("Client: exc: " + e);
        }
    }
}