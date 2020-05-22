@Path("/{parameter: rest1|rest2|rest.n}/users")
public class Users {

    // [rest1|rest2|...]/users/{userID}/username
    @GET
    @Path("/{userID}/username")
    @Produces({MediaType.APPLICATION_JSON,...})
    public Response getUserUsername(@PathParam("userID") String userID) {
        // ... return username for specific user
    }

    // [rest1|rest2|...]/users/usernames
    @GET
    @Path("/usernames")
    @Produces({MediaType.APPLICATION_JSON,...})
    public Response getUsernames() {
        // ... return all usernames
    }