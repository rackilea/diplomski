public class FromPredicate<T> implements Predicate<T> {
    boolean started = false;
    Predicate<T> test;
    FromPredicate(Predicate<T> test) { this.test = test; }

    public static Predicate<T> from(Predicate<T> test) { return new FromPredicate<>(test); }

    public boolean test(T t) {
        return started || (started = test.test(t));
    }
}