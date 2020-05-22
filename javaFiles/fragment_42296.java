public static <T, T1, T2, A1, A2, R1, R2> Collector<T, ?, Tuple2<R1,R2>> both(
    Function<? super T, ? extends Tuple2<? extends T1, ? extends T2>> f,
    Collector<T1, A1, R1> first, Collector<T2, A2, R2> second) {

    return Collectors.mapping(f, both(
            Collectors.mapping(Tuple2::$1, first),
            Collectors.mapping(Tuple2::$2, second)));
}