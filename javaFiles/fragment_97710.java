import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Path(value="/gcm")
@Produces(MediaType.APPLICATION_JSON)
public class GcmResource {
    Client client;

    public GcmResource(Client client) {
        this.client = client;
    }

    @GET
    public String sendMsg() {
        WebResource r = client.resource("https://android.googleapis.com/gcm/send");
        ClientResponse res = r
            .header("Authorization", "key=MY_SERVER_API_KEY")
            .accept(MediaType.APPLICATION_JSON)
            .type(MediaType.APPLICATION_JSON)
            .post(ClientResponse.class, "{\"registration_ids\":[\"ABC\"]}");
        return res.getEntity(String.class);
    }

}