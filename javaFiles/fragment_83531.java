import java.net.*;
import java.io.*;
import java.util.*;

public class ConsoleClient {

    Socket connectionSocket;
    DataInputStream inputStream;
    DataOutputStream outputStream;
    Scanner input;
    double radius;

    public static void main(String[] args) {
        new ConsoleClient();

    }
    public ConsoleClient()
    {
        input = new Scanner(System.in); 
        try 
        {
            connectionSocket = new Socket("Server IP", 8000);
            inputStream = new DataInputStream(connectionSocket.getInputStream());
            outputStream = new DataOutputStream(connectionSocket.getOutputStream());

            System.out.println("Connection established !");

            System.out.println("Please enter a radius: ");
            radius = input.nextDouble();

            outputStream.writeDouble(radius);
            outputStream.flush();

            System.out.println("Data from Client send !");

            System.out.println("The area received is " + inputStream.readDouble());

        }
        catch(Exception ex)
        {
            System.out.println(ex + "");
        }

    }
}