public class JaxRsApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final HashSet<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(MyFeature.class);
        // Register other providers or resources.
        return classes;
    }
}