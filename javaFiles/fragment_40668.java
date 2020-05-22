@Path("a")
public class A {

    @Path("b")
    public B getB() {
       return new B();
    }
}

public class B {
    // blah blah blah
}