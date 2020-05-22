abstract class Foo<T> {
    protected abstract T me();

    public T baz() {
        return me();
    }
}

class Bar extends Foo<Bar> {
    protected Bar me() {
        return this;
    }
}