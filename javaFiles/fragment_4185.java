package comm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class TcpClient {

    private InetAddress connectedAddress;
    private Socket tcpSocket;
    private BufferedReader inBuff;
    private PrintWriter outPrint;
    private int connectedPort;

    public TcpClient(String host, int port){
        try {
            connectedAddress = Inet4Address.getByName(host);
            connectedPort = port;
            this.tcpSocket = new Socket(connectedAddress, connectedPort);
            this.inBuff = new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()));
            this.outPrint = new PrintWriter(tcpSocket.getOutputStream());
            (new Thread(new TcpListeningThread())).start();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message){
        synchronized(this) {
            if(!this.tcpSocket.isConnected())
                return; // Or something more flexible...
            this.outPrint.println(message);
            this.outPrint.flush();
        }   
    }


    private class TcpListeningThread implements Runnable{

        public TcpListeningThread() {
            // Nothing to do...
        }

        @Override
        public void run() {
            try {
                while(true){
                    String newLine = inBuff.readLine();
                    System.out.println(newLine); // Replace this with any processing you want !
                }
            } catch (IOException e) {
                System.err.println("Connection problem");
            }
        }
    }
}