@Path("api/v1")
public class CarsService {

    @GET
    @Path("/cars")
    public Response getCars() {
        ...
    }

    @GET
    @Path("/users/{userId}/cars")
    public Response getUserCars(@PathParam("userId") Long userId) {
        ...
    }
}