import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TrialAutoIt3a {

   // ***** of course your path to program will be different
   private static final String AUTOIT_PATH = "C:/Users/Pete/Documents/Programming/AutoIt/Experiment/";
   private static final String AUTOIT_EXEC = "TestWithJava.exe";
   protected static final CharSequence EXIT = "exit";
   private static Process proc = null;

   public static void main(String[] args) {
      Runtime rt = Runtime.getRuntime();
      System.out.println("Type \"exit\" to exit program");

      try {
         proc = rt.exec(AUTOIT_PATH + AUTOIT_EXEC);
      } catch (IOException e1) {
         e1.printStackTrace();
         System.exit(-1);
      }
      InputStream iStream = proc.getInputStream();
      InputStreamReader isr = new InputStreamReader(iStream);
      final BufferedReader bufReader = new BufferedReader(isr);

      OutputStream oStream = proc.getOutputStream();
      final PrintWriter pw = new PrintWriter(oStream, true);

      Runnable bufReaderRunnable = new Runnable() {
         public void run() {
            String output;
            try {
               while ((output = bufReader.readLine()) != null) {
                  System.out.println(output);
                  if (output.toLowerCase().contains(EXIT)) {
                     proc.destroy();
                     System.exit(0);
                  }
               }
            } catch (IOException e) {
               e.printStackTrace();
            } finally {
               if (bufReader != null) {
                  try {
                     bufReader.close();
                  } catch (IOException e) {
                     e.printStackTrace();
                  }
               }
            }
         }
      };
      new Thread(bufReaderRunnable).start();

      Runnable myRun = new Runnable() {
         public void run() {
            Scanner scan = new Scanner(System.in);
            while (scan.hasNextLine()) {
               String line = scan.nextLine();
               pw.println(line);
            }
            scan.close();
         }
      };
      new Thread(myRun).start();

   }
}