@ApplicationPath("/rest")
public class BookApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
       Set<Class<?>> classes = new HashSet<>();
       classes.add(Bookstore.class);
       return classes;
   }
}