public class SignResource {

    private final SignRepository repository;

    @Inject
    public SignResource(SignRepository repository) {
        this.repository = repository;
    }

    @GET
    public Response signPOST(@QueryParam("type") String type) {
        String signRequest = repository.signRequest(type);
        return Response.status(Response.Status.OK).entity(signRequest).build();
    }
}