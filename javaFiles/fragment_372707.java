public class MyPair<T> {
    private T before;
    private T after;

    private MyPair(T before, T after) {
        this.before = before;
        this.after = after;
    }

    public static <T> MyPair<T> of(final T before, final T after) {
        return new MyPair<>(before, after);
    }

    public T getBefore() {
        return this.before;
    }

    public T getAfter() {
        return this.after;
    }

    public void setBefore(T before) {
        this.before = before;
    }

    public void setAfter(T after) {
        this.after = after;
    }
}