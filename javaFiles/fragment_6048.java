import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;

@GET
@Path("/")
public void example(@Context HttpResponse response, 
                    @Context HttpRequest request) { ... }