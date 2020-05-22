@Path("/")
public class HomeController {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable index() {
        Map<String, String> model = new HashMap<>();
        model.put("hello", "Hello");
        model.put("world", "World");
        return new Viewable("/index", model);
    }
}

public ResourceRegister () {
    ...
    register(HomeController.class);
}