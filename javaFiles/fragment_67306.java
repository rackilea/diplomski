public class Foo {
    Bar bar;

    @Inject
    Foo(Bar bar){
        this.bar = bar;
    }
}