public static <T, U, V> Tuple2<Stream<U>, Stream<V>> unzip(
    Stream<T> stream,  Function<T, Tuple2<U, V>> unzipper) {

    return stream.map(unzipper)
        .collect(Collector.of(()->new Tuple2<>(Stream.<U>builder(), Stream.<V>builder()),
            (unzipped, tuple) -> {
                unzipped.$1().accept(tuple.$1()); unzipped.$2().accept(tuple.$2());
            },
            (unzipped1, unzipped2) -> {
                unzipped2.$1().build().forEachOrdered(unzipped1.$1());
                unzipped2.$2().build().forEachOrdered(unzipped1.$2());
                return unzipped1;
            },
            tuple -> new Tuple2<>(tuple.$1().build(), tuple.$2().build())
        ));
}