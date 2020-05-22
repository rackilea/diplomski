import org.apache.derby.drda.NetworkServerControl;
import java.net.InetAddress;

(...)
NetworkServerControl server = new NetworkServerControl
(InetAddress.getByName("localhost"),1527);
server.start(null);