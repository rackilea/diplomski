@Path("/myservice")
public class MyService {
    @Context
    private SecurityContext securityContext;

    @Path("/something")
    @GET
    public Response getSomething(@Context HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
    }
}