import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient {

   public static void main( String[] args ) throws IOException {
      try(
         Socket socket = new Socket( args[0], 9991 );
         BufferedReader br = new BufferedReader(
            new InputStreamReader( socket.getInputStream(), "utf-8" )))
      {
         String line;
         while(( line = br.readLine()) != null ) {
            System.out.println( line );
         }
      }
   }
}