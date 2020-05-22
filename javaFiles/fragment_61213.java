import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
  public static void main(String[] args) throws Exception {
    final ServerSocket ss = new ServerSocket(12345);
    final Socket cs = ss.accept();
    System.out.println("Accepted connection");

    final InputStream in = cs.getInputStream();
    final byte[] tmp = new byte[64 * 1024];
    while (in.read(tmp) != -1);

    Thread.sleep(100000);
  }
}



import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class MyNioClient {
  public static void main(String[] args) throws Exception {
    final SocketChannel s = SocketChannel.open();
    s.configureBlocking(false);
    s.connect(new InetSocketAddress("localhost", 12345));
    s.finishConnect();

    final ByteBuffer buf = ByteBuffer.allocate(128 * 1024);
    for (int i = 0; i < 10; i++) {
      System.out.println("to write: " + buf.remaining() + ", written: " + s.write(buf));
      buf.position(0);
    }
    Thread.sleep(100000);
  }
}