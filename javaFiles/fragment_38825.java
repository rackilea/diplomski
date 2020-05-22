// This is what the users of your library know about the class
// that does the work:
public interface SomeInterface {
    void doSomethingUseful();
    void doSomethingElse();
}

// This is the class itself, which is hidden from your clients
class MyImplementation implements SomeInterface {
    private SomeDependency dependency = new SomeDependency();
    public void doSomethingUseful() {
        ...
    }
    public void doSomethingElse() {
        ...
    }
}