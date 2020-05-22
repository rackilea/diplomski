@State(Scope.Benchmark)
public class LoopUnswitching {
    private static final int TIMES = 10_000;

    private final Random r = new Random(93);
    private final int[] x = r.ints(TIMES).toArray();
    private final int[] y = r.ints(TIMES).toArray();

    private boolean bool;

    @Setup(Level.Invocation)
    public void setup() {
        bool = r.nextBoolean();
    }

    @Benchmark
    public int test1() {
        int sum = 0;
        for (int i = 0; i < TIMES; i++) {
            if (bool) {
                sum += x[i];
            } else {
                sum += y[i];
            }
        }
        return sum;
    }

    @Benchmark
    public int test2() {
        int sum = 0;
        if (bool) {
            for (int i = 0; i < TIMES; i++) {
                sum += x[i];
            }
        } else {
            for (int i = 0; i < TIMES; i++) {
                sum += y[i];
            }
        }
        return sum;
    }
}