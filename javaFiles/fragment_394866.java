@Path("api/v1/users")
public class UsersService {

    @GET
    @Path("{userId}/cars")
    public Response getUserCars(@PathParam("userId") Long userId) {
        ...
    }
}