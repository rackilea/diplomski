@Path("myresource")
public class MyResource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleData getIt() {

        return new SimpleData();

    }
}