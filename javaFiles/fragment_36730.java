public class NestedLoop {
    private static final int ARRAY_SIZE = 5000;
    private static final int ITERATIONS = 1000000;

    private int[] width = new java.util.Random(0).ints(ARRAY_SIZE).toArray();

    public long inline() {
        long sum = 0;

        for (int i = 0; i < ITERATIONS; i++) {
            int min = width[0];
            for (int k = 1; k < ARRAY_SIZE; k++) {
                if (min > width[k]) {
                    min = width[k];
                }
            }
            sum += min;
        }

        return sum;
    }

    public long methodCall() {
        long sum = 0;

        for (int i = 0; i < ITERATIONS; i++) {
            int min = getMin();
            sum += min;
        }

        return sum;
    }

    private int getMin() {
        int min = width[0];
        for (int k = 1; k < ARRAY_SIZE; k++) {
            if (min > width[k]) {
                min = width[k];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long sum = new NestedLoop().inline();  // or .methodCall();
        long endTime = System.nanoTime();

        long ms = (endTime - startTime) / 1000000;
        System.out.println("sum = " + sum + ", time = " + ms + " ms");
    }
}