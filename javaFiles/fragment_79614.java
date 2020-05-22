import java.net.*;
import java.io.*;
import java.util.*;

public class chatClient
{
public static void main(String[] args) throws IOException, InterruptedException
{
    Socket sock = null;
    PrintStream out = null;
    BufferedReader in = null;
    Scanner sIn = null;

    try
    {
        sock = new Socket("localhost",8000);
        out = new PrintStream(sock.getOutputStream());
        in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        sIn = new Scanner(System.in);
    }
    catch(Exception e)
    {
        System.out.println("Error connecting to server.");
        System.exit(1);
    }

    System.out.println("Connection successful.");

    String temp = "";

    while((temp = sIn.nextLine()) != null)
    {
        out.println(temp);
        Thread.currentThread().sleep(1000);
        while(in.ready())System.out.println(in.readLine());
        out.flush();
        if(temp.equals("end")) break;
    }

    try
    {
        sock.close();
        in.close();
        out.close();
    }
    catch(IOException ioe){}

}