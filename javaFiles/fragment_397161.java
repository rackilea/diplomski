@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 3, time = 1)
@Fork(3)
@State(Scope.Thread)
public class EnhancedFor {

    private static final int SIZE = 100;

    private List<Integer> list;

    @Setup
    public void setup() {
        list = new ArrayList<Integer>(SIZE);
    }


    @GenerateMicroBenchmark
    public int enhanced() {
        int s = 0;
        for (int i : list) {
            s += i;
        }
        return s;
    }

    @GenerateMicroBenchmark
    public int indexed() {
        int s = 0;
        for (int i = 0; i < list.size(); i++) {
            s += list.get(i);
        }
        return s;
    }

    @GenerateMicroBenchmark
    public void enhanced_indi(BlackHole bh) {
        for (int i : list) {
            bh.consume(i);
        }
    }

    @GenerateMicroBenchmark
    public void indexed_indi(BlackHole bh) {
        for (int i = 0; i < list.size(); i++) {
            bh.consume(list.get(i));
        }
    }

}