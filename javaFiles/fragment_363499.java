@Path("/redirect")
public class RedirectResource { 
    @GET
    public Response getRedirect(@Context ServletContext context) {
        UriBuilder builder = UriBuilder.fromPath(context.getContextPath());
        builder.path("index.html");
        return Response.seeOther(builder.build()).build();

    }
}