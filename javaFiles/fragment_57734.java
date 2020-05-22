import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;
public class So43462480take2 {
    class Server extends Thread {
        Server(ServerSocket serverSocket) {
            super("Server");
            this.serverSocket=serverSocket;
        }
        @Override public void run() {
            System.out.println("server running on: "+serverSocket);
            while(true)
                try {
                    Socket socket=serverSocket.accept();
                    final int n=accepts.incrementAndGet();
                    System.out.println("accepted #"+n+" from: "+socket);
                    new Thread(new Runnable() {
                        @Override public void run() {
                            InputStream inputStream=null;
                            try {
                                inputStream=socket.getInputStream();
                                BufferedReader in=new BufferedReader(new InputStreamReader(inputStream));
                                String string=in.readLine();
                                System.out.println(string+" from: "+socket);
                                socket.close();
                                System.out.println(Thread.currentThread().getName()+" succeeded");
                            } catch(IOException e) {
                                System.out.println(Thread.currentThread().getName()+" caught: "+e);
                            }
                        }
                    },"accept #"+n).start();
                } catch(IOException e) {
                    System.out.println(getName()+" caught: "+e);
                    break;
                }
        }
        final ServerSocket serverSocket;
    }
    So43462480take2(String host,Integer service) throws IOException {
        serverSocket=new ServerSocket();
        SocketAddress socketAddress=new InetSocketAddress(host,service);
        serverSocket.bind(socketAddress);
        new Server(serverSocket).start();
    }
    static boolean send(String host,Integer service) {
        Socket socket;
        try {
            socket=new Socket(host,service);
            OutputStreamWriter out=new OutputStreamWriter(socket.getOutputStream());
            out.write("hello\n");
            out.flush();
            socket.close();
            return true;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("start");
        final String host="localhost";
        final Integer service=1237;
        So43462480take2 tcp=new So43462480take2(host,service);
        for(int i=0;i<10;i++) {
            boolean ok=send(host,service);
            if(!ok)
                System.out.println("send failed");
        }
        Thread.sleep(1000);
        try {
        tcp.serverSocket.close();} catch(IOException e) {
            System.out.println("close caught: "+e);
        }
        Thread.sleep(1000);
        for(Thread thread:Thread.getAllStackTraces().keySet())
            System.out.println(thread);
    }
    final ServerSocket serverSocket;
    AtomicInteger accepts=new AtomicInteger();
}