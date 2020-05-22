import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ElasticSearchClientTest {
    public void clientConnectionTest() throws UnknownHostException {

        // Use any settings here (As you mentioned in the code)
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch")
                .put("client.transport.sniff", true)
                .put("sniffOnConnectionFault", true).build();

        TransportClient client = new PreBuiltTransportClient(settings);

        // Change the ip address or the host name accordingly.
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
    }
}