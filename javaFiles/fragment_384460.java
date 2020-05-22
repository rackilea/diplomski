import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class CustomClient {

    public static void main(String[] args) {
        final String HOST_NAME = "127.0.0.1";
        final int SERVER_PORT_NUMBER = 8081;

        try (Socket clientSocket = new Socket(HOST_NAME, SERVER_PORT_NUMBER)) {
            try (BufferedWriter clientOutputStream = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    BufferedReader clientInputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                System.out.println("Connecting....");
                System.out.println("Connected to Server!");

                // Send message to Server
                clientOutputStream.write("CLIENT: HELLO SERVER");
                clientOutputStream.newLine();
                clientOutputStream.flush();

                // Recieve message from Server
                System.out.println("MESSAGE FROM SERVER");
                System.out.println(clientInputStream.readLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}