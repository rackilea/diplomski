@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, batchSize = 1000)
@Measurement(iterations = 10, time = 1, batchSize = 1000)
public class BenchmarkTests {

    @Param({"1000","100","10","5", "1"})
    private int size;
    private int[] original;

    @Setup
    public void setup() {
        original = new int[size];
        for (int i = 0; i < size; i++) {
            original[i] = i;
        }
    }

    @Benchmark
    public int[] SystemArrayCopy() {
        final int length = size;
        int[] destination = new int[length];
        System.arraycopy(original, 0, destination, 0, length);
        return destination;
    }


    @Benchmark
    public int[] arrayClone() {
        return original.clone();
    }

}