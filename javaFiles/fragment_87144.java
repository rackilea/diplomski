@Path("greeting")
public class GreetingResource {

    @Inject
    private IterableProvider<Greeter> greeters;

    @GET
    public Response getResponse(@QueryParam("lang") String lang,
                                @QueryParam("name") String name) throws Exception {

        Greeter greeter = greeters.named(lang).get();
        String message = greeter.getGreeting(name);
        return Response.ok(message).build();
    }
}