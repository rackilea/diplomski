public class RestApplication extends ResourceConfig {
    public RestApplication() {
        register(new RestBinder());

        register(RestServlet.class);
        register(RestService.class);
    }
}