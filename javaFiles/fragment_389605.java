import java.io.IOException;
  import java.io.InputStream;
  import java.net.InetSocketAddress;
  import net.rudp.ReliableSocket;

  /**
  *
  * @author Nika
  */
  public class UDPtestc {
  ReliableSocket server;
   public UDPtestc() throws IOException {
     server = new ReliableSocket();
            server.connect(new InetSocketAddress("127.0.0.1", 9876));
    byte[] buffer = new byte[1024];
    int count,progress=0;
    InputStream in = server.getInputStream();
    while((count=in.read(buffer)) >0){
    progress+=count;
    System.out.println(""+progress);
    }
    server.close();            
    }

    public static void main(String[] args) throws IOException {
    new UDPtestc();
    }

    }