import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.nio.SelectChannelConnector;

public class Main {
    public static void main(String[] args) {

        Server server = new Server();

        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setReuseAddress(false);
        connector.setPort(80);
        server.setConnectors(new Connector[]{connector});

        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace(); 
        }

    }
}