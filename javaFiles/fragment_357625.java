import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class StreamGobbler implements Runnable {

   private InputStream is;
   private GobblerType type;
   private OutputStream os;

   public StreamGobbler(InputStream is, GobblerType type) {
      this(is, type, null);
   }

   public StreamGobbler(InputStream is, GobblerType type, OutputStream redirect) {
      this.is = is;
      this.type = type;
      this.os = redirect;
   }

   public void run() {
      try {
         PrintWriter pw = null;
         if (os != null) {
            pw = new PrintWriter(os, true);
         }
         InputStreamReader isr = new InputStreamReader(is);
         BufferedReader br = new BufferedReader(isr);
         String line = null;
         while ((line = br.readLine()) != null) {
            if (pw != null) {
               pw.println(line);
            }
         }
      } catch (IOException ioe) {
         ioe.printStackTrace();
      }
   }
}