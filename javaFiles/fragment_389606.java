package UDPServer;

  import java.io.FileInputStream; 
  import java.io.IOException;
  import java.io.OutputStream;
  import java.io.RandomAccessFile;
  import java.net.Socket;
  import java.util.logging.Level;
  import java.util.logging.Logger;
  import net.rudp.ReliableServerSocket;
  import net.rudp.ReliableSocket;

  /**
  *
  * @author Nika
  */
  public class UDPtests implements Runnable {

  ReliableServerSocket rss;
  ReliableSocket rs;
  String file;

  FileInputStream bin;

  public UDPtests() throws IOException {
    rss = new ReliableServerSocket(9876);
    Thread serverthread = new Thread(this);
    serverthread.start();

   }

   public void run() {
    while (true) {
        try {
            rs =  (ReliableSocket)rss.accept();
            System.out.println("Connection Accepted");
            System.out.println("" + rs.getRemoteSocketAddress());

              file = "";
        Long size=0L;
             file += "10MB.txt";
                size+=10*1024*1024;

        RandomAccessFile r1= new RandomAccessFile(file,"rw");
        r1.setLength(size);
        byte[] sendData = new byte[1024];

        OutputStream os = rs.getOutputStream();
        //FileOutputStream wr = new FileOutputStream(new File(file));
        bin= new FileInputStream(file);
        int bytesReceived = 0;
        int progress = 0;
        while ((bytesReceived = bin.read(sendData)) > 0) {
            /* Write to the file */
            os.write(sendData, 0, bytesReceived);
            progress += bytesReceived;
            System.out.println(""+progress);
        }



        } catch (IOException ex) {
            Logger.getLogger(udpServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

public static void main(String[] args) throws IOException {
    new UDPtests();
}

}