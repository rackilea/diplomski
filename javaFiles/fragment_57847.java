package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Test {

    public static void main(String[] args) {

        try {

            String hostname = "glacier.us-east-1.amazonaws.com";
            int port = 80;

            InetAddress addr = InetAddress.getByName(hostname);
            Socket socket = new Socket(addr, port);
            // Send headers
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
            wr.write("PUT /AccountId/vaults/VaultName HTTP/1.1\n\r");
            wr.write("Host: glacier.Region.amazonaws.com\n\r");
            wr.write("Date: Date\n\r");
            wr.write("Authorization: SignatureValue\n\r");
            wr.write("Content-Length: Length\n\r");
            wr.write("x-amz-glacier-version: 2012-06-01\n\r");
            wr.write("\n\r");
            wr.flush();

            // Get response
            BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }

            wr.close();
            rd.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}