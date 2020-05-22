public static <T, A1, A2, R1, R2> Collector<T, ?, Tuple2<R1,R2>> both(
    Collector<T, A1, R1> first, Collector<T, A2, R2> second) {

    Supplier<A1> s1=first.supplier();
    Supplier<A2> s2=second.supplier();
    BiConsumer<A1, T> a1=first.accumulator();
    BiConsumer<A2, T> a2=second.accumulator();
    BinaryOperator<A1> c1=first.combiner();
    BinaryOperator<A2> c2=second.combiner();
    Function<A1,R1> f1=first.finisher();
    Function<A2,R2> f2=second.finisher();
    return Collector.of(
        ()->new Tuple2<>(s1.get(), s2.get()),
        (p,t)->{ a1.accept(p.$1(), t); a2.accept(p.$2(), t); },
        (p1,p2)->new Tuple2<>(c1.apply(p1.$1(), p2.$1()), c2.apply(p1.$2(), p2.$2())),
        p -> new Tuple2<>(f1.apply(p.$1()), f2.apply(p.$2())));
}