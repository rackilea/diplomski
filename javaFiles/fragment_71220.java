int count = 0;
long start = System.currentTimeMillis();
for (int i = 0; i < 10000000; i++) {
    try {
        long[] longs = new long[Integer.MAX_VALUE];
    } catch (OutOfMemoryError e) {
        count++;
    }
}
long time = System.currentTimeMillis() - start;
System.out.printf("Got %,d OutOfMemoryErrors in %.1f seconds%n", count, time/1e3);