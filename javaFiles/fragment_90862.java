public class FooBar implements Foo, Bar {
    @Override
    public void doThat() {
        Foo.super.doThat();
    }
}