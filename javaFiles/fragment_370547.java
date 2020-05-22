class SomeClass<T> {
    protected T value;

    public void setValue (T value) {
        this.value = value;
    }

    public T getValue () {
        return value;
    }
}