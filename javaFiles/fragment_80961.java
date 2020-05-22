import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;



/**
 *
 * @author 
 */
public class DaniyarProxyServer {
    public static final int port = 8000;

public static void main(String[] args) {
    ServerSocket listener = null;

    try {
        listener = new ServerSocket(port);
        System.out.println("Proxy started..");
        while (true) {
            try {
                Socket client = listener.accept();
                ClientHandler handler = new ClientHandler(client);
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }
}
}

class ClientHandler implements Runnable {

private Socket client;
private Socket internet;

private Thread thread;

public static int threadcount = 0;

private static int buffer_size = 8192;

private static String CRLF = "\r\n";

public int port = 80;

public ClientHandler(Socket client) {
    this.client = client;
    thread = new Thread(this, "Thread#" + threadcount);
    System.out.println("Thread#" + threadcount + " is running now");
    threadcount++;
    thread.run();
}

@Override
public void run() {
    try {
        byte[] buffer = new byte[buffer_size];
        BufferedInputStream clientIstream = new BufferedInputStream(client.getInputStream());
        clientIstream.read(buffer);

        String clientRequest = new String(buffer);

        System.out.println(clientRequest);

        String host = getHostFromRequest(clientRequest);

        internet = new Socket(host, port);
        BufferedOutputStream internetOstream = new BufferedOutputStream(internet.getOutputStream());
        internetOstream.write(clientRequest.getBytes());
        internetOstream.flush();

        BufferedOutputStream clientOstream = new BufferedOutputStream(client.getOutputStream());

        BufferedInputStream internetIstream = new BufferedInputStream(internet.getInputStream());

        buffer = new byte[buffer_size];
        int buffsize = 0;
        while ((buffsize = internetIstream.read(buffer)) != -1) {
            clientOstream.write(buffer, 0, buffsize);
        }
        clientOstream.flush();

        clientIstream.close();
        clientOstream.close();
        internetIstream.close();
        internetOstream.close();

    } catch (Exception e) {
        System.err.println("Exception " + e.getMessage());
    }
}


private String getHostFromRequest(String request) {
    String host = "";

    StringTokenizer tok = new StringTokenizer(request, CRLF);
    String method = tok.nextToken();
    host = tok.nextToken();

    host = host.substring("Host: ".length());

    return host;
}
}