class Super<T> {
    final Class<T> clazz;

    T foo;

    Super(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T getFoo() {
        return foo;
    }

    public T setFoo() {
        this.foo = foo;
    }
}