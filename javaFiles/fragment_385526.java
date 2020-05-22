@Path("/greetings")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getGreeting() {
        return Response.ok("Hello, World!").build();
    }
}