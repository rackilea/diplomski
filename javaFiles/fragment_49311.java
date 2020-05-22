public static <T, S extends T> void foo3(Consumer<Optional<T>> c, test<S> test) {
    Optional<S> s = null;

    @SuppressWarnings("unchecked")  // Safe because of properties of Optional.
    Optional<T> t = (Optional<T>) (Optional<?>) s;

    c.accept(t);
}