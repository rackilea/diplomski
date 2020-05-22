import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Test {

    public static final int PORT = 22222;

    public static void main(String[] args) throws IOException {
        Thread s = new Thread(new Server());
        Thread c = new Thread(new Client());
        s.start();
        c.start();
    }
}

class Client implements Runnable {

    public Selector selector;

    public SocketChannel sc;

    public Client() throws IOException {
        selector = Selector.open();
    }

    @Override
    public void run() {
        try {
            sc = SocketChannel.open();
            sc.socket().setTcpNoDelay(true);
            sc.configureBlocking(false);
            SelectionKey k = sc.register(selector, SelectionKey.OP_CONNECT);
            boolean firstConnect = sc.connect(new InetSocketAddress("localhost", Test.PORT));
            if (firstConnect) {
                System.out.println("Connected on first connect, de-registering OP_CONNECT");
                k.interestOps(SelectionKey.OP_READ);
            }

            while (true) {
                int keys = selector.selectNow();
                if (keys > 0) {
                    for (SelectionKey key : selector.selectedKeys()) {
                        if (key.isConnectable()) {
                            boolean finishConnectResult = sc.finishConnect();
                            key.interestOps(SelectionKey.OP_READ);
                            System.out.println("Finished connection: " + finishConnectResult);
                        }

                        if (key.isReadable()) {
                            ByteBuffer bb = ByteBuffer.allocate(2);
                            int bytesRead = 0;
                            while ((bytesRead = sc.read(bb)) > 0) {
                                bb.flip();
                                System.out.println(bytesRead + " bytes read");
                                System.out.println(bb.get() + ", " + bb.get());
                                //bb.clear(); // If this is not commented, it will not be handled properly.
                            }
                            System.out.println("Last bytes read value = " + bytesRead);
                            System.exit(0);
                        }
                    }
                }

                Thread.sleep(5);
            }
        } catch (Exception e) { 
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

class Server implements Runnable {

    public Selector selector;

    public SocketChannel sc;

    public Server() throws IOException {
        selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.bind(new InetSocketAddress(Test.PORT));
        ssc.register(selector, SelectionKey.OP_ACCEPT);
    }

    @Override
    public void run() {
        boolean notSentData = true;
        try {
            while (true) {
                int keys = selector.selectNow();
                if (keys > 0) {
                    for (SelectionKey key : selector.selectedKeys()) {
                        if (key.isAcceptable()) {
                            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                            sc = ssc.accept();
                            if (sc != null) {
                                sc.configureBlocking(false);
                                sc.socket().setTcpNoDelay(true); // Required in my application
                                sc.register(selector, SelectionKey.OP_WRITE);
                                System.out.println("Server accepted connection");
                            } else {
                                System.out.println("Got null connection");
                            }
                        }
                    }
                }

                if (sc != null && notSentData) {
                    ByteBuffer bb = ByteBuffer.allocate(4);
                    bb.put(new byte[]{ 1, 2, 3, -1});
                    bb.flip();
                    int wrote = sc.write(bb);
                    System.out.println("Wrote " + wrote + " bytes");
                    notSentData = false;
                }

                Thread.sleep(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}