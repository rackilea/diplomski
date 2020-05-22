@ApplicationScoped
@Path("single")
public class SingleResource {

    private boolean activated;

    @GET
    @Path("activate")
    public Response activate() {
        activated = true;
        return Response.ok("Service Activated", MediaType.TEXT_PLAIN_TYPE)
                .build();
    }

    @GET
    @Path("deactivate")
    public Response deactivate() {
        activated = false;
        return Response.ok("Service Deactivated", MediaType.TEXT_PLAIN_TYPE)
                .build();
    }

    @GET
    public Response foo() {
        if (activated) {
            return Response.ok("Service Available", MediaType.TEXT_PLAIN_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.SERVICE_UNAVAILABLE)
                    .entity("Service Unavailable")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }
}