import java.net.Socket;
import java.io.PrintWriter;
import java.io.*;

public class App {

    public static void main(String[] args) throws Exception {
        String host = "google.com";
        int port = 80;
        Socket socket = new Socket(host, port);

        //BufferedWriter writer = new BufferedWriter(
        //       new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.write("GET / HTTP/1.1\r\n");
        writer.write("Connection: Close\r\n");
        writer.write("\r\n");
        writer.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

        // reader.lines().forEach(System.out.println);
        String line;
        System.out.println("Reading lines:");
        while ((line = reader.readLine()) != null) {
            System.out.println("* " + line);
        }
        System.out.println("DONE READING RESPONSE");

        reader.close();
        writer.close();
        // socket.close();

        System.out.println("Finished"); 
    }

}