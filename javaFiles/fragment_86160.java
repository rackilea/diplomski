import java.util.Random;

public class ArrayOptimization {
    public static void main(String[] args) {
        int size = 10;
        long[] data = new long[size];
        Random r = new Random();
        for ( int i = 0; i < data.length; i++ ) {
            data[i] = r.nextLong();
        }

        Array[] a = new Array[] {
                new NoOpArray(),
                new NormalArray(size),
                new TenArray(size)
        };

        for (;;) {
            for ( int i = 0; i < a.length; i++ ) {
                testSet(a[i], data, 10000000);
                testGet(a[i], data, 10000000);
            }
        }
    }

    private static void testGet(Array a, long[] data, int iterations) {
            long nanos = System.nanoTime();
        for ( int i = 0; i < iterations; i++ ) {
            for ( int j = 0; j < data.length; j++ ) {
                data[j] = a.get(j);
            }
        }
        long stop = System.nanoTime();
        System.out.printf("%s/get took %fms%n", a.getClass().getName(), 
                (stop - nanos) / 1000000.0);
    }

    private static void testSet(Array a, long[] data, int iterations) {
        long nanos = System.nanoTime();
        for ( int i = 0; i < iterations; i++ ) {
            for ( int j = 0; j < data.length; j++ ) {
                a.set(j, data[j]);
            }
        }
        long stop = System.nanoTime();
        System.out.printf("%s/set took %fms%n", a.getClass().getName(), 
                (stop - nanos) / 1000000.0);

    }
}