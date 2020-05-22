import javax.ws.rs.*;
import javax.ws.rs.core.Response;
@Path("/test")
public class BaseResource {
  @GET @Produces("text/plain") @Path("test") public Response helloWorld() {
    return Response.ok("Hello world","plain/text").build();
  }
  @GET @Produces("text/plain") public String helloWorld2() {
    return "Hello world without path!";
  }
}