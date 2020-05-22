@Path("/myapi")
@Produces("application/json")
public interface MyRestApi {

    /// Some methods here that accept complex object and work fine
    // @Consumes("application/json")
    // public void somemethods() ...

    @GET
    @Path("/methodwithstring")
    @Consumes("text/plain")   
    public void methodWithString(final String thumbprint,
        @Context final HttpServletResponse response);
}