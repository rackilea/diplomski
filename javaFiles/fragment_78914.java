import java.net.*;
import java.io.*;

public class Server
{
    static ServerSocket   serverSocket;
    static Socket         socket;
    static BufferedWriter writer;
    static BufferedReader reader;

    public static void main(String args[])
    {
        try
        {
            System.out.println("Hola mundo");
            serverSocket = new ServerSocket(12345);
            socket = serverSocket.accept();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while(true)
            {
                String command = reader.readLine();
                if(command.contains("mkdir"))
                {
                    System.out.println("Creating a new directory " + command);
                    // put yoour code to create a directory with the params
                }
                else if(command.equals("exit"))
                {
                    System.out.println("Exiting the program");
                    break;
                }
            }
        }
        catch(Exception err)
        {

        }
    }
}