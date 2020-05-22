public final class Function<T> {
    private final Class<T> type;
    private Function(Class<T> type) {
        this.type = type;
    }
    public Class<T> getType() {
        return type;
    }
    public static final Function<Integer> VOLUME = new Function<>(Integer.class);
    public static final Function<Boolean> IS_RUNNING = new Function<>(Boolean.class);
    public static final Function<String> NAME = new Function<>(String.class);
}