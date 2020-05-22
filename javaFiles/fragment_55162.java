@ApplicationPath("/rest")
public class AppConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(RestService.class);
        return classes;
    }
}