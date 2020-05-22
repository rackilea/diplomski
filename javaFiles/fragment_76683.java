@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@Fork(1)
@State(Scope.Thread)
public class ValueOfPerfTest {

    @Param({ "1000" })
    private String number;

    @Param({ "10", "20", "30"})
    private long tokens;

    @Benchmark
    public void cachedValueOf(Blackhole blackhole) {
        Long l = Long.valueOf(number);

        // three times using the consume
        blackhole.consume(l);
        blackhole.consume(l);
        blackhole.consume(l);

        Blackhole.consumeCPU(tokens);
    }

    @Benchmark
    public void nonCachedValueOf(Blackhole blackhole) {
        // three times using the consume
        blackhole.consume(Long.valueOf(number));
        blackhole.consume(Long.valueOf(number));
        blackhole.consume(Long.valueOf(number));

        Blackhole.consumeCPU(tokens);
    }

    @Benchmark
    public Long valueOf(Blackhole blackhole) {
        Blackhole.consumeCPU(tokens);

        return Long.valueOf(number);
    }

    @Benchmark
    public void baseline(){
        Blackhole.consumeCPU(tokens);
    }

}