@VmOptions("-server")
public class Test {

    @Benchmark
    public int timeSum1(long reps) {
        int dummy = 0; 
        int x = 9, y = 9;
        for (int j = 0; j < reps; j++) {
            dummy = x + y;
        }
        return dummy;
    }

    @Benchmark
    public int timeSum2(long reps) {
        int dummy = 0; 
        int x = 9, y = 9;
        for (int j = 0; j < reps; j++) {
            dummy = sum(x, y);
        }
        return dummy;
    }

    public static int sum(int x, int y) {
        int t;
        t = x + y;
        return t;
    }
}