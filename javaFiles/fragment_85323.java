public abstract class Token<T> {
    private static final MarkerToken MARKER = new MarkerToken<>();

    public boolean isMarker() {
        return false;
    }

    public static <T> MarkerToken<T> marker() {
        return MARKER;
    }

    public static <T> ValueToken<T> value(T o) {
        return new ValueToken<>(o);
    }

    public static class ValueToken<T> extends Token<T> {
        T value;

        public ValueToken(T value) {
            this.value = value;
        }

        public T get() {
            return value;
        }
    }

    public static class MarkerToken<T> extends Token<T> {
        public boolean isMarker() {
            return true;
        }
    }

}