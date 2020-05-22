public static class NamedPredicate<T> implements Predicate<T> {
    final Predicate<T> predicate;
    final String name;

    public NamedPredicate(Predicate<T> predicate, String name) {
        this.predicate = predicate;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean test(T t) {
        return predicate.test(t);
    }
}