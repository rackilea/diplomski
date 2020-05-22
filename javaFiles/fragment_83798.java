@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ExceptionHandler
@Traced
@Log
public class ResourceEndpoint {

    @Inject
    @RestClient
    Api api;

    @GET
    @Path("/latest")
    public Response getFooBarLatest() {

        return Response.ok(this.api.getFoorBar()).build();
    }