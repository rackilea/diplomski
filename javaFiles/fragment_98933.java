import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ClientTask implements Runnable {

    private final Socket clientSocket;

    public ClientTask(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        System.out.println("Got a client...");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream())) {
            String message = "Hello";
            os.writeBytes("HTTP/1.0 200 OK\r\n");
            final String currentDateFormatted = DateTimeFormatter.RFC_1123_DATE_TIME.format(ZonedDateTime.now(ZoneOffset.UTC));
            os.writeBytes("Date: " + currentDateFormatted + "\r\n");
            os.writeBytes("Server: Java Server/12234\r\n");
            os.writeBytes("Content-Type: text/plain\r\n");
            os.writeBytes("Content-Length: " + message.length() + "\r\n");
            os.writeBytes("Expires: " + currentDateFormatted + "\r\n");
            os.writeBytes("Last-modified: " + currentDateFormatted + "\r\n");
            os.writeBytes("\r\n");
            os.write(message.getBytes(StandardCharsets.UTF_8));
            os.flush();
            os.close();
            System.out.println("About to close..");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}