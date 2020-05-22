public class Holder<T> {
    T value;
    public Holder(T value) {
        this.value = value;
    }
    // getter/setter
}

public void method(Holder<Foo> foo) {
    foo.setValue(something);
}