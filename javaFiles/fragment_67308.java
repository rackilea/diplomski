public class Main {
    Foo foo;

    @Inject
    Main(Foo foo) {
        this.foo = foo;
    }
}