import java.io.*; 
import java.net.*; 
import java.util.*;


class Client 
{  
    public static void main(String argv[]) throws Exception  
    {   
        try
        {
            //declare scanner object
            Scanner s = new Scanner(System.in);

            //display a message to the user
            System.out.println("Enter the file name you wish to request");

            //read the user input 
            String textFileName = s.nextLine();

            //declare a new Socket object and specify the host name and the port number
            Socket clientSocket = new Socket("localhost", 6789);

            // Send the filename via the connection
            OutputStream oS = clientSocket.getOutputStream();
            BufferedWriter bW = new BufferedWriter(new OutputStreamWriter(oS));
            bW.write(textFileName);

            //make a byte array in which the transmitted file will be broken down into and sent
            byte[] bArray = new byte[10000000];

            //create new inputstream object and set it to the input stream from the client
            InputStream is = clientSocket.getInputStream();

            //open new fileinput object
            FileOutputStream fos = new FileOutputStream(split[1]);

            //get the value from the fileoutputstream to bufferedoutput stream
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            //read function of the inputsteam object
            int readFile = is.read(bArray,0,bArray.length);

            //assign readfile to endile
            int endFile = readFile;

            do
            {
                readFile = is.read(bArray, endFile, (bArray.length-endFile));

                if(readFile >= 0)
                {
                    endFile = endFile + readFile;
                }
            }while(readFile > -1);

            //write file
            bos.write(bArray, 0, endFile);

            //show the message to the user
            System.out.println("File " + textFileName + " was successfully received!");

            //flush the file
            bos.flush();

            //close the file
            bos.close();

            //close the socket
            clientSocket.close();

            ///

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}