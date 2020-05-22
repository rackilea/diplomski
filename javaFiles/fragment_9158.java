public final class ValueType<T> {
    public static final ValueType<Boolean> BOOLEAN = new ValueType<>(Boolean.class);
    public static final ValueType<Integer> INTEGER = new ValueType<>(Integer.class);

    private final Class<T> clazz;

    private ValueType(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Class<T> getType() {
        return clazz;
    }
}