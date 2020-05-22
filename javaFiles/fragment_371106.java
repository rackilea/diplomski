import java.io.*;
import java.net.*;

public class ServerSide {


    public static void main(String[] args) {

        try
        {
            ServerSocket myServerSocket = new ServerSocket(9999);
            System.out.println("Server is waiting on host" + InetAddress.getLocalHost().getCanonicalHostName() + "port= "+ myServerSocket.getLocalPort());
            Socket skt = myServerSocket.accept();

            BufferedReader myInput = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            PrintStream myOutput = new PrintStream(skt.getOutputStream());

            String buf = myInput.readLine();
            System.out.println("Server readLine");
            if(buf!=null)
            {
                System.out.println("Buf = " + buf);
                myOutput.print("Got it?");
            }
            else
            {
                System.out.println("Nothing returned in server sidex`x  ");
            }
            skt.close();
            System.out.println("Server shutdown");
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.println("Whooops");
        }
    }

}