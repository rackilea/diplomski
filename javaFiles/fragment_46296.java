import java.net.*;
import java.io.*;
public class MainProgram {

private static String host;
public static void main(String[] args) 
{
    host = "192.168.0.13";

    for (int i = 1; i < 10001 ; i++)
    {
        try {
            Socket socket = new Socket(host , i);
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
          }
      }
  }

}