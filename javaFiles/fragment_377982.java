@Benchmark
public sequential(Blackhole bh) {
    bh.consume(StreamSupport.stream(myContainer.spliterator(), false).reduce((a, b) -> a));
}

@Benchmark
public parallel(Blackhole bh) {
    bh.consume(StreamSupport.stream(myContainer.spliterator(), true).reduce((a, b) -> a));
}