package your.package.warLauncher;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.HandlerCollection;

public class WarLauncher{

  public static void main(String[] args) throws Exception {
      JettyServerContext context = new JettyServerContext();
      Server server = new Server();

      // Create connector
      SocketConnector connector = new SocketConnector();
      connector.setMaxIdleTime(1000 * 60 * 60);
      connector.setSoLingerTime(-1);
      connector.setPort(8080);

      // Create handler collection
      ContextHandlerCollection contextHandlerCollection = new   ContextHandlerCollection();
      HandlerCollection handlerCollection = new HandlerCollection();
      handlerCollection.setHandlers(new Handler[] { contextHandlerCollection });

      // Add webapp context
      context.setServer(server);
      contextHandlerCollection.addHandler(context);

      server.setConnectors(new Connector[] { connector });
      server.setHandler(handlerCollection);
      server.start();
  }
}