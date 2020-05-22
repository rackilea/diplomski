import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

import oshi.SystemInfo;

public class WebSocket {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        ServerSocket server = new ServerSocket(80);
        try {
            System.out.println("Server has started on 127.0.0.1:80.\r\nWaiting for a connection...");
            Socket client = server.accept();
            System.out.println("A client connected.");
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();
            Scanner s = new Scanner(in, "UTF-8");
            try {
                String data = s.useDelimiter("\\r\\n\\r\\n").next();
                Matcher get = Pattern.compile("^GET").matcher(data);
                if (get.find()) {
                    SystemInfo si = new SystemInfo();
                    ObjectMapper mapper = new ObjectMapper();
                    byte[] response = ("HTTP/1.1 200 OK\r\n" + "Content-Type: application/json\r\n"
                            + "Accept: application/json\r\n"
                            // end header
                            + "\r\n"
                            // write JSON
                            + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(si))
                                    .getBytes(StandardCharsets.UTF_8);
                    out.write(response, 0, response.length);
                }
            } finally {
                s.close();
            }
        } finally {
            server.close();
        }
    }
}