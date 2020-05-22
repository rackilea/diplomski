@Test
public void threadPoolTest() throws InterruptedException {
    ExecutorService  threadPool = Executors.newFixedThreadPool(8);

    final CountDownLatch latch = new CountDownLatch(2);

    threadPool.submit(new Runnable() {
        public void run() {
            i++;
            latch.countDown();
        }
    });
    threadPool.submit(new Runnable() {
        public void run() {
            i++;
            latch.countDown();
        }
    });
    latch.await();
    assertEquals(2,i);
    threadPool .shutdown();
}