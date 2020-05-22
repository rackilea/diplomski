@Fork(1)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Measurement(iterations = 500, time = 50, timeUnit = TimeUnit.MILLISECONDS)
@Warmup(iterations = 10)
@BenchmarkMode(Mode.Throughput)
public class StringSearchBenchmark {
    private static final String STATE = "absdefghijklmnopqrstuvwxyzabsdefghijklmnopqrstuvwxyzabsdefghijklmnopqrstuvwxyzabsdefghijklmnopqrstuvwxyz";
    private static final String SEARCH_TERM = "abcd";

    @Benchmark
    public void testContains(Blackhole sink) {
        sink.consume(STATE.contains(SEARCH_TERM));
    }

    @Benchmark
    public void testIndexOf(Blackhole sink) {
        sink.consume(STATE.indexOf(SEARCH_TERM));
    }
}