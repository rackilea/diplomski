@Path("/myappname")
public class CatchItAll {

    @GET
    @Path("/{anyThing:.*}")
    public String catch(@PathParam("anyThing") String anyThing) {

    }
}