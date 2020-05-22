static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ? extends U> var0) {
    Objects.requireNonNull(var0);
    return (Comparator)((Serializable)((var1x, var2x) -> {
        return ((Comparable)var0.apply(var1x)).compareTo(var0.apply(var2x));
    }));
}