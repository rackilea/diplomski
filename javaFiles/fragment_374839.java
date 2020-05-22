@ApplicationPath("api")
public class RestApplication extends Application{

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();
    public RestApplication(){
         //below line caused @Inject not to work. commented out
         //singletons.add(new PersonService());  
    }
    @Override
    public Set<Class<?>> getClasses() {
         return empty;
    }
    @Override
    public Set<Object> getSingletons() {
         return singletons;
    }
}