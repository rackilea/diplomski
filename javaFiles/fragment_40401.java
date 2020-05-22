public static <T, U> U reduceWithCancel(Stream<T> stream, U identity,
        BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner,
        Predicate<U> cancelPredicate) {
    return StreamSupport
            .stream(new CancellableReduceSpliterator<>(stream.spliterator(), identity,
                    accumulator, cancelPredicate), stream.isParallel()).reduce(combiner)
            .orElse(identity);
}

public static <T> T reduceWithCancel(Stream<T> stream, T identity,
        BinaryOperator<T> combiner, Predicate<T> cancelPredicate) {
    return reduceWithCancel(stream, identity, combiner, combiner, cancelPredicate);
}