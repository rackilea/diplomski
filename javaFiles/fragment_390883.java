import java.net.InetSocketAddress;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class JavaApplication11 {
    public static void main(String[] args) throws Exception {
    Charset charset = Charset.forName("ISO-8859-1");
    SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 1024));
    sc.configureBlocking(true);
    ByteBuffer b = ByteBuffer.allocate(32);
    //b.flip();//Don't flip the ByteBuffer here because it sets the position to 0 and limit to 0 also. Hence no read.
    int a = sc.read(b);
    sc.close();
    b.flip();//sets the Position to 0 and limit to the number of bytes to be read.
    CharBuffer c = charset.decode(b);
    //c.flip();//Don't flip the ChharBuffer. Because it is setting the position to zero and limit to previous position i.e zero
    System.out.println("Got " + c);
    System.out.println("read " + a );
    }
}