public interface Foo { .. }
public class FooImpl { .. } // this is declared as bean

public class Bar {
    private FooImpl foo; // this fails
    private Foo foo; // correct way
}