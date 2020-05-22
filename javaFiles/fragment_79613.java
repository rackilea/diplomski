import java.net.*;
import java.io.*;
import java.util.*;

public class chatServer
{   
public static void main(String[] args) throws IOException
{
    ServerSocket ss = null;
    try
    {
        ss= new ServerSocket(8000);
    }
    catch(IOException ioe){System.out.println("Can't connect to port.");}

    Socket sock = null;
    try{sock = ss.accept();}
    catch(IOException ioe){System.out.println("Can't connect to client.");}
    System.out.println("Connection successful.");

    PrintWriter out = null;
    Scanner in = null;

    try{
        out = new PrintWriter(sock.getOutputStream(),true);
        in = new Scanner(sock.getInputStream());
    }catch(Exception e)
    {
        System.out.println("Error.");
    }

    String line;
    String lines = "";

    while((line = in.nextLine()) != null)
    {
        switch(line)
        {
            case "list":
                out.println("1. bla  |  2. ble  |  3. bli");break;
            case "group":out.println("Here group will be chosen.");break;
            case "header":out.println("Returns header.");break;
            case "loop":
                FileReader fr = new FileReader("D:\\Eclipse\\TestFiles\\text2.txt");
                BufferedReader br = new BufferedReader(fr);
                while((lines = br.readLine()) != null)
                {
                    out.println(lines);
                }
                break;
            default:
                if(!(line.equals("end")))
                {
                    out.println("Unknown command.Try again.");
                    break;
                }
        }
        if(line.equals("end"))
        {
            out.println("Connection over.");
            break;
        }
    }
    try{
            in.close();
            out.close();
            sock.close();
            ss.close();
        }catch(IOException ioe){}

}