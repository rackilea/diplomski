public static <T extends Comparable<T>, E extends Collection<T>> E sort(
    Collection<T> a, 
    Supplier<E> factory) {

    return a.stream().sorted().collect(Collectors.toCollection(factory));
}