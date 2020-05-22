public static <T, R> R reduce(Supplier<R> init, Iterable<T> sequence, BiFunction<R, T, R> function) {
    R accumulator = init.get();
    for ( final T item : sequence ) {
        accumulator = function.apply(accumulator, item);
    }
    return accumulator;
}