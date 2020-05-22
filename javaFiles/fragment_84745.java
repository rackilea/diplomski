@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class MyBenchmark {

    @Param({"0", "1", "255", "4294967295", "-1"})
    public long value;

    @Benchmark
    public int testBitSet() {
        int count = 0;
        int max = 0;
        BitSet bitSet = BitSet.valueOf(new long[]{value});
        for (int i = 0; i < bitSet.size(); i++) {
            if (bitSet.get(i)) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return max;
    }

    @Benchmark
    public int testBitWiseOperation() {
        int max = 0;
        int count = 0;
        while (value > 0) {
            if ((value & 1) == 1) count++;
            else {
                if (count > max) max = count;
                count = 0;
            }
            if (count > max) max = count;
            value = value >> 1;
        }
        return max;
    }

    @Benchmark
    public int testRecursion() {
        return getMaxBits(value);
    }
    public static int getMaxBits(long number) {
        return accGetMaxBits(number, 0);
    }

    private static int accGetMaxBits(long number, int accum) {
        if (number == 0) return accum;
        accum += 1;
        return accGetMaxBits(number & (number >>> 1), accum);
    }
}