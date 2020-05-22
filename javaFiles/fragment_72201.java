@Path("/")
@RequestScoped
public class Root {
    @GET
    public Response index() {
        return Response.ok().build();
    }
}