@Path("context")
public class ContextResource {

    @Inject
    MyObject o;

    @GET
    public String get() {
        return o.get();
    }

}