static int keep, keep2;
static int counter;

public static void main(String[] args) {
    Object o = new Object();
    Object o2 = new Object();
    int runs = 100_000_000;
    for (int t = 0; t < 5; t++) {
        long start = System.nanoTime();
        for (int i = 0; i < runs; i+=2) {
            UNSAFE.putOrderedInt(o, 1L, (counter += 0x5bc80bad) & 0x7FFFFFFF);
            UNSAFE.putOrderedInt(o2, 1L, (counter += 0x5bc80bad) & 0x7FFFFFFF);
            keep = o.hashCode(); // reload the hashCode
            keep2 = o2.hashCode(); // reload the hashCode
        }
        long time = System.nanoTime() - start;
        System.out.printf("Object.hashCode takes %,d ns on average%n", time / runs);
    }
}