@Path("/rest")
public class RESTService {

    @Inject
    KwetterService service;

    @GET
    @Path("/user/{userName}")
    public User getUser(@PathParam("userName") String userName)
    {
        return service.findByName(userName);
    }

    @GET
    @Path("/user/{userName}/tweets")
    @Produces(MediaType.TEXT_XML)
    public Collection<Tweet> getTweets(@PathParam("userName") String userName)
    {
        User user = service.findByName(userName);
        return user.getTweets();
    }
}