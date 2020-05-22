private final ConcurrentMap<String, CountDownLatch> map = new ConcurrentHashMap<>(); 

public void test(String hash) {
    final CountDownLatch latch = new CountDownLatch(1);
    final CountDownLatch previous = map.putIfAbsent(hash, latch);
    if (previous == null) {
        try {
            callLongRunningMethod();
        } finally {
            map.remove(hash, latch);
            latch.countDown();
        }
    } else {
        try {
            previous.await();
            callLongRunningMethod();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}