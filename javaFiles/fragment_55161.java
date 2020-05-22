@ApplicationPath("/rest")
public class AppConfig extends Application {}

@Path("/")
public class RestService {
    @GET
    @Path("/sayhello")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        return Response.ok("Hello World").build();
    }
}