public class Replacer<T> {

    private final T value;
    private T replacementValue;

    private Replacer(T value) {
        this.value = value;
    }

    public static <V> Replacer<V> replace(V value) {
        return new Replacer<V>(value);
    }

    public Replacer<T> with (T replacementValue) {
        this.replacementValue = replacementValue;
        return this;
    }

    public T when(boolean condition) {
        if (condition) {
            return replacementValue;
        } else {
            return value;
        }
    }

}