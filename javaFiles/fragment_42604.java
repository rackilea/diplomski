import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
@Path("/")
public class BookResource {
    @GET
    @Path("/get")
    @Produces({ "application/json" })
    public String getHelloWorld() {
        return "{\"result\":\"";
    }
}