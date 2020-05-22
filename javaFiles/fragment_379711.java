@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class Temp {

    private Object value;

    @Setup
    public void setUp() {
        value = 50;
    }

    @Benchmark
    public boolean list1() {
        return List.of("one").contains(value);
    }

    @Benchmark
    public boolean list2() {
        return List.of("one", "two").contains(value);
    }

    @Benchmark
    public boolean list3() {
        return List.of("one", "two", "three").contains(value);
    }

    @Benchmark
    public boolean list4() {
        return List.of("one", "two", "three", "four").contains(value);
    }

    @Benchmark
    public boolean set1() {
        return Set.of("one").contains(value);
    }

    @Benchmark
    public boolean set2() {
        return Set.of("one", "two").contains(value);
    }

    @Benchmark
    public boolean set3() {
        return Set.of("one", "two", "three").contains(value);
    }

    @Benchmark
    public boolean set4() {
        return Set.of("one", "two", "three", "four").contains(value);
    }
}