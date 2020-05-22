import java.io.PrintWriter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

/**
 * REST Web Service
 *
 * @author Irshad kk
 */

@Path("WS")
@RequestScoped

public class SSEResource {
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SSEResource
     */
    public SSEResource() {
    }

    @GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public String getServerSentEvents() {
        System.out.println("haii" + System.currentTimeMillis()); 
        return "data: " + "irshad" + System.currentTimeMillis() + "\n\n";
    }
}