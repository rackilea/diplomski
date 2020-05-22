@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient
@RegisterProvider(LoggingFilter.class)
public interface Api {

    @GET
    @Path("/foo/bar")
    FooBar getFoorBar();