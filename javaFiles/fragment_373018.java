@Path("basic")
@Stateless
public class ServiceRS {

    @EJB private IServiceJAX wsi;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String result(@PathParam("id") String id) {
        return wsi.hello(id);
    }
}