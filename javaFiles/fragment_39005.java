@Path("/login")
public class LoginController {

    @GET
    public Viewable loginPage() {
        ...
        return new Viewable("/login", model);  // to login.jsp
    }

    @POST
    public Response loginPost(Form form, @Context UriInfo uriInfo) {
        ...
        UriBuilder builder = uriInfo.getBaseUriBuilder();
        if (success) {
            builder.path("/feed");  // to FeedController GET
        } else {
            builder.path("/login"); // to LoginController GET
        }

        return Response.seeOther(builder.build()).build();
    }
}

@Path("/feed")
public class FeedController {

    @GET
    public Viewable getFeed() {
        ...
        return new Viewable("/feed", model);  // to feed.jsp
    }   
}