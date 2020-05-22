import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/not-rest")
@Produces("application/json")
public class NotRestBean {

    @GET
    public Response getSoapStyle() {
        String json = "{}"; // build your response here
        return Response.ok(json).build();
    }
}