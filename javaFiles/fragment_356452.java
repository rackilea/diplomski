@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class HashMapBenchmark {

    @Benchmark
    public String get() {
        HashMap<String, String> hm = createMap();
        return hm.get("bye");
    }

    @Benchmark
    public String remove() {
        HashMap<String, String> hm = createMap();
        return hm.remove("bye");
    }

    // extra protection from optimization
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    private HashMap<String, String> createMap() {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("bye", "bye");
        return hm;
    }
}