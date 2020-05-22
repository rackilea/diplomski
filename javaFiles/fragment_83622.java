@Path("/models")
public class ModelController {

    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModels() throws Exception {
        ...
    }
}