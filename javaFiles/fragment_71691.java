@Path("test")
public class TestResource {

    @Context
    private SecurityContext sc;

    @GET
    public String get() {
        TestFilter.User user = (TestFilter.User) sc.getUserPrincipal();
        return user.getEmail();
    }
}