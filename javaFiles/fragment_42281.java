import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

class ClientThread extends Thread {

   private final Socket _socket;

   public ClientThread( Socket socket ) {
      System.out.println( "New client" );
      _socket = socket;
      setDaemon( true );
      start();
   }

   @Override
   public void run() {
      try(
         final OutputStream outputFromServer = _socket.getOutputStream();
         final PrintWriter serverPrintOut = new PrintWriter(
            new OutputStreamWriter( outputFromServer, "utf-8" ), true ))
      {
         serverPrintOut.println( "Welcome to time server" );
         for(;;) {
            final long elapsed = System.currentTimeMillis() - MyServer.StartTime;
            serverPrintOut.println( elapsed );
            Thread.sleep( 1000L );
         }
      }
      catch( final InterruptedException ex) {/**/}
      catch( final IOException e ) {
         e.printStackTrace();
      }
   }
}

public class MyServer {

   static Calendar startTime = Calendar.getInstance();
   static long StartTime = System.currentTimeMillis();

   public static void main( String[] args ) throws IOException {
      try( ServerSocket serverSocket = new ServerSocket( 9991 )) {
         for(;;) {
            new ClientThread( serverSocket.accept());
         }
      }
   }
}