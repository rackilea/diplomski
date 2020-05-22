public class Bar {

    private Foo foo;

    @Inject
    public Bar(@Named("foo") Foo foo) {
        this.foo = foo;
    }

    //some other methods
}