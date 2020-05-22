@Path("/{parameter: rest1|rest2|rest.n}")
public class Rest {

    @GET
    @Path("/users")
    @Produces({MediaType.APPLICATION_JSON,...})
    public Response getUsers() {
        // ...
    }

    @GET
    @Path("/sports")
    @Produces({MediaType.APPLICATION_JSON,...})
    public Response getSports() {
        // ...
    }