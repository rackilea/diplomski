import java.io.*;
import java.net.*;

public class Client {


    public static void main(String[] args)
    {

        String hostAddress = "localhost";
        int port = 8080;

        Socket socket = null;


        String test = "hello"; //decode bytes from this string on the server

        byte[] byteArray = test.getBytes();


        try 
        {
            socket = new Socket(hostAddress, port);
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            dos.write(byteArray, 0, byteArray.length);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
    }
}