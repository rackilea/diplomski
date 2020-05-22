import java.io.*;
import java.net.*;

class Server 
{   
    public static void main(String argv[]) throws Exception
    {
        //beginning of the try method
        try
        {

            //create a new serversocket object with port no 6789
            ServerSocket welcomeSocket = new ServerSocket(6789);

            //while loop
            while(true)          
            {
                //create a new socket object and accept the connection and it waits for any connection from client
                Socket connectionSocket = welcomeSocket.accept();// TODO - Make a new thread after the connection is accepted

                //display confirmation to the user
                System.out.println("Connection accepted!");

                // Recover the fileName from client
                String fileName = "";
                InputStream iS = connectionSocket.getInputStream();
                InputStreamReader iSR = new InputStreamReader(iS);
                BufferedReader bR = new BufferedReader(iSR);
                fileName = bR.readLine();
                System.out.println("File request received : " + fileName);

                // Recover the file's byte array
                File myFile = new File(fileName);
                byte[] bArray = new byte[(int)myFile.length()];
                FileInputStream f = new FileInputStream(myFile);
                BufferedInputStream bs = new BufferedInputStream(f);
                bs.read(bArray, 0, bArray.length);

                //display messages to the users
                System.out.println("Okay, sending the file now.");

                //declare new output strea object
                OutputStream os = connectionSocket.getOutputStream();
                os.write(bArray, 0, bArray.length);
                os.flush();

                //close the connection
                connectionSocket.close();

                //display confirmation message to the user
                System.out.println("File was successfully sent!");

            }       
        }
        catch(Exception e)
        {
        System.out.println(e.getMessage());
        }
    }
}