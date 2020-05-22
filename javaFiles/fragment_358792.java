@ApplicationPath("/app")
public class JmsApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(SimpleJMSRestfulWebService.class);
        return classes;
    }
}