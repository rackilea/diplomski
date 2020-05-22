static class ExampleStatistics implements Consumer<ExampleClass> {

    private Integer sum = 0;
    private Integer product = null;

    @Override
    public void accept(ExampleClass value) {
        sum += value.getX();

        if (product == null) {
            product = value.getY();
        } else {
            product *= value.getY();
        }
    }

    public ExampleStatistics combine(ExampleStatistics other) {
        sum += other.sum;
        product *= other.product;
        return this;
    }

    public Integer getSum() {
        return sum;
    }

    public Integer getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return String.format("Sum X = %d, Product Y = %d", sum, product);
    }

}

static class ExampleSummarizer 
    implements Collector<ExampleClass, ExampleStatistics, ExampleStatistics> {

    @Override
    public Supplier<ExampleStatistics> supplier() {
        return ExampleStatistics::new;
    }

    @Override
    public BiConsumer<ExampleStatistics, ExampleClass> accumulator() {
        return (r, t) -> r.accept(t);
    }

    @Override
    public BinaryOperator<ExampleStatistics> combiner() {
        return (r, t) -> r.combine(t);
    }

    @Override
    public Function<ExampleStatistics, ExampleStatistics> finisher() {
        return i -> i; // identity finish
    }

    @Override
    public Set<Collector.Characteristics> characteristics() {
        return Stream.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED)
                .collect(toSet());
    }

};