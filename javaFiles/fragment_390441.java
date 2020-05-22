@State(Scope.Thread)
public class MyBenchmark {

    private List<Foo> singleMapList = new ArrayList<>();

    private List<Foo> doubleMapList = new ArrayList<>();

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public List<Integer> singleMap() {
        return singleMapList.stream().map(foo ->     Integer.parseInt(foo.getId())).collect(Collectors.toList());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public List<Integer> doubleMap() {
        return doubleMapList.stream().map(Foo::getId).map(Integer::parseInt).collect(Collectors.toList());
}

    @Setup
    public void setup() {
        for (int i = 0; i < 100_000; i++) {
            singleMapList.add(new Foo("" + i));
            doubleMapList.add(new Foo("" + i));
        }
    }

     public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(MyBenchmark.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }
}