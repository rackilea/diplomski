public class Lookup {
    private static final Foo foo = new FooImpl();
    public static Foo getFoo() { 
        return foo; 
    }
}