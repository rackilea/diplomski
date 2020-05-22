public class Bar {
    private T foo;

    public Optional<T> getFoo() {
        return Optional.<T>fromNullable(foo);
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }
}