CountDownLatch latch = new CountDownLatch(1);
Runnable r = () -> {
    try {
        latch.await();
        System.out.println("Thread proceeds.");
    } catch (InterruptedException e) { /* NOP */ }
};

new Thread(r).start();
new Thread(r).start();

try {
    TimeUnit.SECONDS.sleep(1L);
    System.out.println("Count down.");
    latch.countDown();
} catch (InterruptedException e) { /* NOP */ }