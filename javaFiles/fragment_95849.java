import java.io.*;
import java.net.*;
import java.util.*;

public class proxy2 {

  public static void main(String args[]) throws Exception
  {
    int port = Integer.parseInt(args[0]);
    File fileSub= new File(args[1]); //fileSub
    File fileRediect = new File(args[2]); //fileRedirect

    //create listener socket to listen for requests from browser
    ServerSocket listener = new ServerSocket(port);

    while (true) {
      proxy_func(listener.accept());
    }

  }

  public static void proxy_func(Socket clientSocket) throws Exception{

    OutputStream outputToClient = clientSocket.getOutputStream();
    InputStream inputFromClient = clientSocket.getInputStream();

    //store clientSocket's inputstream into a buffer

    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    int nRead; //start offset in the data
    byte[] data = new byte[16384]; 
    //read each byte from InputStream and write it to a ByteArrayOutputStream
    while((nRead = inputFromClient.read(data, 0, data.length)) != -1) {
      System.out.println("reading from client...");
      buffer.write(data, 0, nRead);
      //if reached end of HTTP request, break out of this loop
      if(endOfRequest(data) == true)
        break;
    }
    buffer.flush(); //forces any buffered bytes to be written out
    data = buffer.toByteArray(); //retrieve the underlying byte array 
    System.out.println(new String(data));

    //create buffered reader for byte array input stream (request data)
    InputStream inputStream = new ByteArrayInputStream(data);
    BufferedReader readFromClient = new BufferedReader(new InputStreamReader(inputStream));

    String[] strArr;
    String line;
    String hostname = null;

    //get hostname
    while(  (line=readFromClient.readLine()) != null)
    {
      strArr = line.split(" ");
      if(strArr[0].equals("Host:"))
        hostname = strArr[1];
    }
    System.out.println("Host: " + hostname);

    //create server socket
    Socket serverSocket = new Socket(hostname, 80);
    OutputStream outputToServer = serverSocket.getOutputStream();
    //InputStream inputFromServer = serverSocket.getInputStream();

    //forward request to server
    System.out.println("forward request to server...");
    outputToServer.write(data);

    //receive data from server and write response back to client
    DataInputStream inputFromServer = new DataInputStream(serverSocket.getInputStream());
    byte[] receivedData = new byte[1024];
    int size;
    while((size = inputFromServer.read(receivedData, 0, receivedData.length)) != -1)
    {
      System.out.println("write response back to client...");
      System.out.println(new String(receivedData));
      outputToClient.write(receivedData, 0, size);
      outputToClient.flush();
    }

    System.out.println("done sending");
    outputToClient.close();
  }

  //method to detect end of HTTP request
  //return true if detected, otherwise false
  public static boolean endOfRequest(byte[] data) throws Exception
  {
    System.out.println("parsing request..");
    BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data)));
    String line;

    while( (line=br.readLine()) != null) {
      if (line.equals(""))
        return true;
    }
    return false;
  }
}