import java.io.*;
import java.net.*;

public class ClientDemo {

    public static void main(String[] args) {

        try {
            Socket sock = new Socket("127.0.0.1", 4321);
            // Build a Buffered Reader - it is easier to read complete line
            BufferedReader input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            // After connecting we read the first 2 line
            // We know that the server send 2 lines
            System.out.println(input.readLine());
            System.out.println(input.readLine());
            // Wen must have a reader for our inputs
            InputStreamReader consoleReader = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(consoleReader);
            while (true) {
                // read one line from the console
                String inline = in.readLine();
                inline += "\n";
                // send the line to the server
                sock.getOutputStream().write(inline.getBytes());
                sock.getOutputStream().flush();
                // Wait for server response - we know that we get 2 lines
                for (int i = 0; i < 2; i++) {
                    String response = input.readLine();
                    if (response == null || inline.equals("Exit")) {
                        break;
                    } else {
                        System.out.println(response);
                    }

                }
            }
        } catch (IOException e) {
        }
    }
}