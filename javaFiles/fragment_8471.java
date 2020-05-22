public class Test {
    public static final long N = 40;

    static {
        long t = System.currentTimeMillis();
        computeStatic1(N);
        System.out.println("computeStatic1 in initializer: " + (System.currentTimeMillis() - t));

        Test x = new Test();
        t = System.currentTimeMillis();
        x.compute1(N);
        System.out.println("compute1 in initializer: " + (System.currentTimeMillis() - t));

        computeStatic2(10); // Not enough to launch JIT
        x.compute2(10); // Not enough to launch JIT
    }     

    public static void main(String[] args) throws Exception {
        long t = System.currentTimeMillis();
        computeStatic1(N);
        System.out.println("computeStatic1 in main: " + (System.currentTimeMillis() - t));

        Test x = new Test();
        t = System.currentTimeMillis();
        x.compute1(N);
        System.out.println("compute1 in main: " + (System.currentTimeMillis() - t));

        t = System.currentTimeMillis();
        computeStatic2(N);
        System.out.println("computeStatic2 in main: " + (System.currentTimeMillis() - t));

        t = System.currentTimeMillis();
        x.compute2(N);
        System.out.println("compute2 in main: " + (System.currentTimeMillis() - t));
    }

    private long compute1(long n) {
        if (n == 0 || n == 1) return 1;
        else return compute1(n - 2) + compute1(n - 1);
    }

    private static long computeStatic1(long n) {
        if (n == 0 || n == 1) return 1;
        else return computeStatic1(n - 2) + computeStatic1(n - 1);
    }

    private long compute2(long n) {
        if (n == 0 || n == 1) return 1;
        else return compute2(n - 2) + compute2(n - 1);
    }

    private static long computeStatic2(long n) {
        if (n == 0 || n == 1) return 1;
        else return computeStatic2(n - 2) + computeStatic2(n - 1);
    }
}