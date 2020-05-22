@Path("/error")
public class ErrorResource {

    @GET
    @Path("404")
    @Produces(MediaType.TEXT_HTML)
    public Response error404() {
       return Response.status(Response.Status.NOT_FOUND)
                      .entity("<html><body>Error 404 requesting resource.</body></html>")
                      .build();
    }