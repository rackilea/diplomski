abstract public class B {
    /** Override to implement the subclass logic */
    abstract protected SomeClass reallyCalculateStuff();

    /** The public API method to be called by clients of the class */
    final public SomeClass calculateStuff() {
        executeSharedCode();
        return reallyCalculateStuff();
    }

    /** The method all other methods need to call */
    private void executeSharedCode() {
        // ...
    }
}

public class A extends B {
    @Override
    protected SomeClass reallyCalculateStuff() {
        // ...
    }
}