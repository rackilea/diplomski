@Path("root")
public class Resource {

    @Context
    ResourceContext context;

    @Path("sub/{id}")
    public SubResource get() {
        return context.getResource(SubResource.class);
    }
}