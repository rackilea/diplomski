package javaapplication12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketExample {
    private ServerSocket middleman;
    private int port = 8080;
    private Socket client;


    protected void createSocketServer()
    {
        try
        {
            while (true){
                middleman = new ServerSocket(port);
                client = middleman.accept();
                middleman.close();
                PrintWriter out = new PrintWriter(client.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                String line;
                while((line = in.readLine()) != null)
                {
                    System.out.println("echo: " + line);
                    out.println("test");
                }
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        SocketExample test = new SocketExample();
        test.createSocketServer();
    }
}