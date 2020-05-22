import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CustomServer {

    public static void main(String[] args) {
        final int SERVER_PORT_NUMBER = 8081;

        try (ServerSocket serverObj = new ServerSocket(SERVER_PORT_NUMBER)) {
            try (Socket clientSocketObj = serverObj.accept()) {
                try (BufferedReader clientInputStream = new BufferedReader(new InputStreamReader(clientSocketObj.getInputStream()));
                        BufferedWriter clientOutputStream = new BufferedWriter(new OutputStreamWriter(clientSocketObj.getOutputStream()))) {

                    System.out.println("Client Connected to Server!");

                    // Recieve Message from Client
                    System.out.println("MESSAGE FROM CLIENT");
                    System.out.println(clientInputStream.readLine());

                    // Send Message to Client
                    clientOutputStream.write("SERVER: Hello Client!");
                    clientOutputStream.newLine();
                    clientOutputStream.flush();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}