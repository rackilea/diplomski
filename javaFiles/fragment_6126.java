import java.io.*;
import java.net.*;


public class Server {

    public static void main(String[] args) throws SocketException 
    {
        try
        {                       
            ServerSocket server = new ServerSocket(8080);
            server.setSoTimeout(0);

            Socket connectionToClient = server.accept();
            InputStream is = connectionToClient.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            int buffersize = connectionToClient.getReceiveBufferSize();

            byte[] bytes = new byte[buffersize];


            if(dis.read(bytes) > 0)
            {
                String s = new String(bytes);
                System.out.print(s);
            }   


            dis.close();
            server.close();
        }
        catch(IOException e)
        {       
            e.printStackTrace();
            System.err.println("Server was terminated.");
        }
    }
}