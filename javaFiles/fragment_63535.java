@Path("/myservice")
public class MyService {
    @Context
    private SecurityContext securityContext;

    @Path("/something")
    @GET
    public Response getSomething() {
        User user = (User)securityContext.getUserPrincipal();
    }
}