import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class Jest {

    public static void main(String[] args) throws IOException {
        // Construct a new Jest client according to configuration via factory
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig.Builder("http://localhost:9200")
                .multiThreaded(true)
                .build());
        JestClient client = factory.getObject();

        GetStartPage getStartPage = new GetStartPage.Builder().build();
        try {
            JestResult execute = client.execute(getStartPage);
            System.out.println("result =" + execute.getJsonString());
        } catch (IOException ex) {
            Logger.getLogger(Jest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}