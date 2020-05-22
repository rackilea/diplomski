@Path("/foo")
public class MyResource() {

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public String wontCache() {
         ...
    }
}