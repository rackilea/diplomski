@ApplicationPath("/resteasy")
public class MarkersApplication extends Application {

    private static final Set<Object>    singletons  = new HashSet<Object>();

    public MarkersApplication() {
        singletons.add(new MarkersRest());
    }

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>();
        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}