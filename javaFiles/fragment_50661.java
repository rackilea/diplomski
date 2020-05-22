public class Foo{
    public Foo(int a, int b) {
        System.out.println("Foo constructor with-args is called");
    }
    public Foo() {
        System.out.println("Foo with no-args is called");
    }
}
class Bar extends Foo {
    public Bar() {
        // Implicit call to super()
        super(); 

        // Explicit call to super(a,b);
        // This will not compile unless the call above has been removed.
        super(1,2);
    }
}