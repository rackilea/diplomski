import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;
public class So43462480 {
    public interface Consumer<T> { // instead of 1.8 definition
        void accept(T t);
    }
    class Server extends Thread {
        Server(ServerSocket serverSocket,Consumer<Socket> consumer) {
            super("Server");
            this.serverSocket=serverSocket;
            this.consumer=consumer;
        }
        @Override public void run() {
            System.out.println("server running on: "+serverSocket);
            while(true)
                try {
                    Socket socket=serverSocket.accept();
                    if(consumer!=null)
                        consumer.accept(socket);
                } catch(IOException e) {
                    System.out.println(getName()+" caught: "+e);
                    break;
                }
        }
        final ServerSocket serverSocket;
        final Consumer<Socket> consumer;
    }
    void read(Socket socket) {
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
    So43462480(String host,Integer service) throws IOException {
        ServerSocket serverSocket=new ServerSocket();
        SocketAddress socketAddress=new InetSocketAddress(host,service);
        serverSocket.bind(socketAddress);
        Consumer<Socket> socketConsumer=new Consumer<Socket>() {
            @Override public void accept(Socket socket) {
                final int n=accepts.incrementAndGet();
                System.out.println("accepted #"+n+" from: "+socket);
                new Thread(new Runnable() {
                    @Override public void run() {
                        read(socket);
                    }
                },"accept #"+n).start();
            }
        };
        new Server(serverSocket,socketConsumer).start();
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
    public static void main(String[] args) throws InterruptedException {
        final String host="localhost";
        final Integer service=1237;
        try {
            So43462480 tcp=new So43462480(host,service);
        } catch(Exception e) {
            System.out.println("main caught: "+e);
        }
        for(int i=0;i<10;i++) {
            boolean ok=send(host,service);
            if(!ok)
                System.out.println("send failed");
        }
        Thread.sleep(100);
        for(Thread thread:Thread.getAllStackTraces().keySet())
            System.out.println(thread);
    }
    AtomicInteger accepts=new AtomicInteger();
}