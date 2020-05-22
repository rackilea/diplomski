public final class ImmutableWrapper<T extends Number> {

    private final T value;

    public ImmutableWrapper(T value) {
        // a subclass of Number may be mutable
        // so, how to defensively copying the value?
        this.value = SerializationUtils.clone(value);
    }

    public T getValue() {
        // the same here: how to return a copy?
        return  SerializationUtils.clone(value);
    }
}