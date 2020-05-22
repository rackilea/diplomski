public class CollectorTester<T, A, R> {

    private final Supplier<A> supplier;
    private final BiConsumer<A, T> accumulator;
    private final Function<A, R> finisher;
    private final BinaryOperator<A> combiner;

    public CollectorTester(Collector<T, A, R> collector) {
        this.supplier = collector.supplier();
        this.accumulator = collector.accumulator();
        this.combiner = collector.combiner();
        this.finisher = collector.finisher();
    }

    // Tests that an accumulator resulting from the inputs supplied
    // meets the identity constraint
    public void testIdentity(T... ts) {
        A a = supplier.get();
        Arrays.stream(ts).filter(t -> t != null).forEach(
            t -> accumulator.accept(a, t)
        );

        assertThat(combiner.apply(a, supplier.get()), equalTo(a));
    }

    // Tests that the combiner meets the associativity constraint
    // for the two inputs supplied
    // (This is verbatim from the Collector JavaDoc)
    // This test might be too strict for UNORDERED collectors
    public void testAssociativity(T t1, T t2) {
        A a1 = supplier.get();
        accumulator.accept(a1, t1);
        accumulator.accept(a1, t2);
        R r1 = finisher.apply(a1); // result without splitting

        A a2 = supplier.get();
        accumulator.accept(a2, t1);
        A a3 = supplier.get();
        accumulator.accept(a3, t2);
        R r2 = finisher.apply(combiner.apply(a2, a3)); // result with splitting

        assertThat(r1, equalTo(r2));
    }

}