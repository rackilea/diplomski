public class Server
{
private ServerSocket serverSocket;

public Server(int port) throws IOException
{
  serverSocket = new ServerSocket(port);
  // optional timeout part depending on your application.
  serverSocket.setSoTimeout(10000);
}

public closeDialog(){
try{
Socket server = serverSocket.accept();
dialog.dispose();
// Rest of your code
}
catch(SocketTimeoutException s)
     {
        System.out.println("Socket timed out!");
     }catch(IOException e)
     {
        e.printStackTrace();
     }
  }
// Rest of your code
}