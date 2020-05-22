public static <T> Stream<T> stream(Iterable<T> in) {
    return StreamSupport.stream(in.spliterator(), false);
}

public static <T> Stream<T> parallelStream(Iterable<T> in) {
    return StreamSupport.stream(in.spliterator(), true);
}