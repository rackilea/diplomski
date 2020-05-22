@Path("foo")
@Stateless
public class FooResource {

    @EJB
    private SingleBean dummyBean;

    @GET
    @Path("activate")
    public Response activate() {
        dummyBean.setActivated(true);
        return Response.ok("Service Activated", MediaType.TEXT_PLAIN_TYPE)
                .build();
    }

    @GET
    @Path("deactivate")
    public Response deactivate() {
        dummyBean.setActivated(false);
        return Response.ok("Service Deactivated", MediaType.TEXT_PLAIN_TYPE)
                .build();
    }

    @GET
    public Response foo() {
        if (dummyBean.isActivated()) {
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