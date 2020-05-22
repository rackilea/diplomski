public class BarImpl implements Bar {
    @Override
    public Foo getFoo() {
        return new Fizz();
    }
    @Override
    public Foo getAnotherFoo() {
        return new Buzz();
    }
}