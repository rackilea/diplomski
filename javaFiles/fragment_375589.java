@Path("/MyService")
public class MyService {

    @GET
    @Produces
    @path("getIntentClassIds")
    public String getIntentClassIds() {
        return "this works fine";
    }

    @GET
    @Path("getIntentClassById/{x}")
    @Produces
    public String getIntentClassById(@PathParam("x") String intentClassId) {
        return "This does not work";
    }

}