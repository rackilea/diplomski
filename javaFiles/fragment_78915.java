import java.net.*;
import java.io.*;

public class Client
{
    static Socket socket;
    static BufferedWriter writer;
    static BufferedReader reader;
    public static void main(String args[])
    {
        try
        {
            System.out.println("Connecting to the server");
            InetSocketAddress address = new InetSocketAddress("127.0.0.1", 12345);
            socket = new Socket();
            socket.connect(address);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // creating folder
            System.out.println("Creating remote folder");
            writer.write("mkdir newFolder\r\n");
            writer.flush();


            // closing server
            System.out.println("Sending exit command");
            writer.write("exit\r\n");
            writer.flush();

            socket.close();
        }
        catch(IOException err)
        {
            System.out.println(err.getMessage());
        }
    }
}