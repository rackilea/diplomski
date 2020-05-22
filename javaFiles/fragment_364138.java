class FooCollector implements Collector<Foo, FloatAcc, Float> {
    @Override
    public Supplier<FloatAcc> supplier() {
        return () -> new FloatAcc(0f);
    }
    @Override
    public BiConsumer<FloatAcc, Foo> accumulator() {
        return (v, foo) -> v.accumulate(foo.v1 * foo.v2);
    }
    @Override
    public BinaryOperator<FloatAcc> combiner() {
        return (v1, v2) -> {
            v1.accumulate(v2.get());
            return v1;
        };
    }
    @Override
    public Function<FloatAcc, Float> finisher() {
        return FloatAcc::get;
    }
    @Override
    public Set<Characteristics> characteristics() {
        Set<Characteristics> characteristics = new TreeSet<>();
        return characteristics;
    }
}