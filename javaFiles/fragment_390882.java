import java.net.InetSocketAddress;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class JavaApplication12 {
    public static void main(String[] args) throws Exception{
    Charset charset = Charset.forName("ISO-8859-1");
    ServerSocketChannel s = ServerSocketChannel.open();
    s.configureBlocking(true);
    s.socket().bind(new InetSocketAddress(1024));

    CharBuffer c = CharBuffer.wrap("Hello from server!");
    System.out.println("writing " + c);
    ByteBuffer b = charset.encode(c);
    System.out.println(new String(b.array()));
    SocketChannel sc = s.accept();
    //sc.configureBlocking(true);
    b.compact();
    System.out.println(b.capacity() + " "+ b.position() + " " + b.limit());
    b.flip();
    System.out.println(b.capacity() + " "+ b.position() + " " + b.limit());
    int a = 0;
    while (b.hasRemaining())
    {
        a += sc.write(b);
    }

    sc.close();
    s.close();
    System.out.println("wrote " + a);
    }
}