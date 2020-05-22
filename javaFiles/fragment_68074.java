import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/roles")
public class MessageRestService {

    @GET
    @Path("/1")
    @Produces(MediaType.APPLICATION_JSON)
    public Response badURLS() {
        return Response.ok().entity("OK").build();
    }

}