@Benchmark
@Measurement(timeUnit = TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
public int first() throws IOException {
    return i % 2;
}

@Benchmark
@Measurement(timeUnit = TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
public int second() throws IOException {
    return i & 0x1;
}