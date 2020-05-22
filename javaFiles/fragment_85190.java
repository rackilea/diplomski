import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.webapp.WebAppContext;

public class StartJetty {
       public static void main(String[] args) throws Exception {
               Server server = new Server();
               SocketConnector connector = new SocketConnector();
               // Set some timeout options to make debugging easier.
               connector.setMaxIdleTime(1000 * 60 * 60);
               connector.setSoLingerTime(-1);
               connector.setPort(8081);
               server.setConnectors(new Connector[] { connector });

               WebAppContext bb = new WebAppContext();
               bb.setServer(server);
               bb.setContextPath("/");
               bb.setWar("src/main/webapp");
               server.addHandler(bb);

               try {
                       System.out.println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY
KEY TO STOP");
                       server.start();

                       //Launch browser
                       if (Desktop.isDesktopSupported())
                               if (Desktop.getDesktop().isSupported(Desktop.Action.BROWSE))
                                       try {
                                               Desktop.getDesktop().browse(new URI("http://localhost:8081/"));
                                       }
                                       catch (IOException ioe) {
                                               ioe.printStackTrace();
                                       }
                                       catch (URISyntaxException use) {
                                               use.printStackTrace();
                                       }

                       System.in.read();
                       System.out.println(">>> STOPPING EMBEDDED JETTY SERVER");
                       server.stop();
                       server.join();
               }
               catch (Exception e) {
                       e.printStackTrace();
                       System.exit(100);
               }
       }
}