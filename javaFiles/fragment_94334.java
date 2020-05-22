@Test
public void fineForFiveSeconds() {
    long start = System.nanoTime();
    long end = start + TimeUnit.SECONDS.toNanos(5);
    while (System.nanoTime < end()) {
        test.executeOneIteration();
    }
}