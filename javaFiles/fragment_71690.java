@Path("test")
public class TestResource {

    @GET
    public String get(@Context SecurityContext sc) {
        TestFilter.User user = (TestFilter.User) sc.getUserPrincipal();
        return user.getEmail();
    }
}