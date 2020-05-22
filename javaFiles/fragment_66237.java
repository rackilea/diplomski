public class Main {
    static final double TEST_SIZE = 100000000.0;
    static final double BILLION = 1000000000.0;

    public static void main(String[] args) {
        testStandard();
        testSync();
    }

    static void testStandard() {
        long startTime = System.nanoTime();
        for (int i =0; i < TEST_SIZE; i++) {
        }
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/ BILLION  + " seconds");
    }

    static void testSync() {
        long startTime = System.nanoTime();
        for (int i =0; i < TEST_SIZE; i++) {
            synchronized (Main.class) {}
        }
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/ BILLION  + " seconds");
    }
}