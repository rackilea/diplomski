@Path("/some/things")
public class ThingsListResource {
    @Inject
    SomeStorage store;

    @Inject
    ThingResourceFactory thingResourceFactory;

    @GET
    public List<Thing> getAllThings() {
        return store.getAllThings();
    }

    @Path("{id}")
    public ThingResource getThingResource(@PathParam("id") String id) {
        return thingResourceFactory.create(id);
    }
}