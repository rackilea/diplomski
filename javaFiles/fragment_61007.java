import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import java.io.InputStream;
import java.util.Scanner;
import com.fazecast.jSerialComm.*;

public class sendSMS extends HttpServlet {
    SerialPort ubxPort;

    static String messageString1 = "AT";
    static String messageString2 = "AT+CMGF=1"; 
    static String messageString3 = "AT+CMGS=\"+xxxxxxxxxx\"";
    static String messageString4 = "TESTY2";
    static char enter = 13;
    static char CTRLZ = 26;


   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {

      // Set the response MIME type of the response message
      response.setContentType("text/html");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();


      try {

          ubxPort = SerialPort.getCommPort("com7");
          boolean openedSuccessfully = ubxPort.openPort();
          out.println("h1<br>");
          if(openedSuccessfully)
          {
            out.println("Port Opened<br>");
            byte[] buffer = (messageString1 + enter).getBytes();
            ubxPort.writeBytes(buffer, buffer.length);
            out.println("1 sent<br>");

            InputStream in = ubxPort.getInputStream();
            try
            {
               for (int j = 0; j < 1000; ++j)
                  System.out.print((char)in.read());
               in.close();
            } catch (Exception e) { e.printStackTrace(); }

            buffer = (messageString2 + enter).getBytes();
            ubxPort.writeBytes(buffer, buffer.length);
            out.println("2 sent<br>");

            try
            {
               for (int j = 0; j < 1000; ++j)
                  System.out.print((char)in.read());
               in.close();
            } catch (Exception e) { e.printStackTrace(); }

            buffer = (messageString3 + enter).getBytes();
            ubxPort.writeBytes(buffer, buffer.length);
            out.println("3 sent<br>");

            try
            {
               for (int j = 0; j < 1000; ++j)
                  System.out.print((char)in.read());
               in.close();
            } catch (Exception e) { e.printStackTrace(); }

            buffer = (messageString4 + CTRLZ).getBytes();
            ubxPort.writeBytes(buffer, buffer.length);
            out.println("4 sent<br>");

            try
            {
               for (int j = 0; j < 1000; ++j)
                  System.out.print((char)in.read());
               in.close();
            } catch (Exception e) { e.printStackTrace(); }

          }

      }
      catch(Exception e)
      {
          out.println("here3");
          out.println(e.getMessage());
      }
      finally {
          ubxPort.closePort();
          out.println("here4");
         out.close();  // Always close the output writer
      }
   }
}