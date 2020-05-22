@ApplicationPath("/rest")
public class RESTApplication extends Application {
@Override

    private SingletonServiceObject getMySingletonService(){
        ... Do whatever to setup your singleton ...
    }

    public Set<Object> getSingletons() {
        L.info("Setting up REST - getSingletons()");
        Set<Object> singletons = new HashSet<Object>();
        try {
            singletons.add(getMySingletonService());
            singletons.add(new GeoService());
        } catch (IOException e) {
            throw new ProjectRuntimeException("Error creating service!", e);
        }
        L.info("Finished REST - getSingletons()");
        return singletons;
    }
}