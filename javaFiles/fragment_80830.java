@Path("main")
public class MainResource {

    @GET 
    @Path("fuzz/{foo}/{bar}")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuzz(@PathParam("foo") String foo, @PathParam("bar") Integer bar) {

        // Do the real work.
        SomeClass someClass = new SomeClass();
        SomeResult someResult = someClass.fuzz(foo, bar);

        // Return result.
        return someResult.toString();
    }

}