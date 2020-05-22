public class MyApplicaton extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(com.foo.resources.MyResource.class);
        return s;
    }
}