@Path("/test")
public class TestResource {
    @GET
    public String get() {
        return "Testing";
    }
}

@ApplicationPath("/api")
public class MyApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(TestResource.class);
        return classes;
    }
}