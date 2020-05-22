@ApplicationPath("rest")
public class RestService extends Application {

    @GET
    @Path("/sayhello")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        return Response.ok("Hello World").build();
    }
}