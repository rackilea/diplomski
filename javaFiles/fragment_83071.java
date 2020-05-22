@Path("foo")
public class Test {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(Foo foo) {
        ...
    }
}