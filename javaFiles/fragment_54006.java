public static <T,R> List<List<R>> applyToAll(
    Collection<? extends Collection<? extends T>> source,
    Function<? super T, ? extends R> op) {

    return source.stream()
        .map(c -> c.stream().map(op).collect(Collectors.toList()))
        .collect(Collectors.toList());
}