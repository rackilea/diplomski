public class AssistedFoo extends Foo {
    @AssistedInject
    public AssistedFoo(
        Bar bar,
        @Assisted Baz baz) {
        super(bar, baz);
    }
}