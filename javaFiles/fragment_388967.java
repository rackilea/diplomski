public class Main {

    public static final int RUNS = 100000000;

    static final ThreadLocal<StringBuilder> STRING_BUILDER_THREAD_LOCAL = new ThreadLocal<StringBuilder>() {
        @Override
        protected StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public static final StringBuilder myStringBuilder() {
        StringBuilder sb = STRING_BUILDER_THREAD_LOCAL.get();
        sb.setLength(0);
        return sb;
    }

    public static long testSeparate(String x, String y, String z) {
        long start = System.nanoTime();
        for (int i = 0; i < RUNS; i++) {
            StringBuilder s = myStringBuilder();
            s.append(x)
                    .append(y)
                    .append(z);
            dontOptimiseAway = s.toString();
        }
        long time = System.nanoTime() - start;
        return time;
    }

    public static long testChained(String x, String y, String z) {
        long start = System.nanoTime();
        for (int i = 0; i < RUNS; i++) {
            StringBuilder s = myStringBuilder();
            s.append(x);
            s.append(y);
            s.append(z);
            dontOptimiseAway = s.toString();
        }
        long time = System.nanoTime() - start;
        return time;
    }

    static String dontOptimiseAway = null;

    public static void main(String... args) {
        for (int i = 0; i < 10; i++) {
            long time1 = testSeparate("x", "y", "z");
            long time2 = testChained("x", "y", "z");
            System.out.printf("Average time separate %.1f ns, chained %.1f ns%n",
                    (double) time1 / RUNS, (double) time2 / RUNS);
        }
    }
}