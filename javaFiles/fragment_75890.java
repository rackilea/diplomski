public class HashCodePerf {
    static int keep;

    public static void main(String[] args) {
        Object o = new Object();
        int runs = 20_000_000;
        for (int t = 0; t < 5; t++) {
            long start = System.nanoTime();
            for (int i = 0; i < runs; i++) {
                UNSAFE.putInt(o, 1L, 0); // reset the memory which stores the hashCode
                keep = o.hashCode(); // compute a new hashCode
            }
            long time = System.nanoTime() - start;
            System.out.printf("Object.hashCode takes %,d ns on average%n", time / runs);
        }
    }

    static final Unsafe UNSAFE;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}