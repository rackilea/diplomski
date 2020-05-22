@Path("/test")
public class TestResource {

    @Context
    ServletContext context;

    @GET
    public Response getTest() {
        ServletRegistration registration = 
                context.getServletRegistration("JAX-RS Servlet");
                                                // ^^^ Your servlet name
        Collection<String> mappings = registration.getMappings();
        for (String mapping: mappings) {
            System.out.println("Url Pattern: " + mapping);
        } 
        ...
    }
}