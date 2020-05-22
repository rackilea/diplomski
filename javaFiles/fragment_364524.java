import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread {
private BufferedReader reader;
private Socket clientSocket;
private EchoServer server;

public ClientHandler(BufferedReader reader, Socket clientSocket EchoServer server) 
{
    this.reader = reader;
    this.server = server;
    this.clientSocket = clientSocket;
}

@Override
public void run() {
    while (true) {
        String inputLine;
        try {
            while ((inputLine = reader.readLine()) != null)
            {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(inputLine);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
}