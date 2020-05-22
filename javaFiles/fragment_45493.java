import android.content.Context;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by Kintan Patel on 01-08-2016.
 */
public class SocketConnection {
    private Socket socket = null;
    private OutputStream outputStream;
    private DataOutputStream dataOutputStream;
    private SessionHelper helper;

    public String EstablishConnection(String token) {
   // token = your message that write on socket server
        String response;
        try {

            //socket = new Socket("192.168.0.24", 2129); // Testing Server
            socket = new Socket("Your IpAddress", PORT NO); 
            outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(token);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            response = br.readLine();

        } catch (UnknownHostException e) {
            e.printStackTrace();
            response = "UnknownHostException: " + e.toString();
            return null;

        } catch (SocketException e) {
            e.printStackTrace();
            response = "Sorry Fail to connect";
            return null;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();

            response = "Sorry Fail to connect";
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            response = "Server Break";
            return null;

        } finally {
            if (socket != null) {
                try {
                    socket.close();
                    outputStream.close();
                    dataOutputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return response;
    }
}