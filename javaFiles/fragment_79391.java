import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
    ClientConfig clientConfig = new DefaultClientConfig();
    clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
    //clientConfig.getProperties().put(ClientConfig.PROPERTY_CHUNKED_ENCODING_SIZE, null);
    Client client = Client.create(clientConfig);
    client.addFilter(new LoggingFilter(System.out));

    String postURL = "https://api.napster.com/v2.2/me/library/tracks?id=tra.169783383,tra.30621111";
    WebResource webResourcePost = client.resource(postURL);
    //webResourcePost.header("Content-Length", 0);
    ClientResponse response = webResourcePost.type("application/json").post(ClientResponse.class, "{}");
    System.out.println(response.getStatus());
  }
}