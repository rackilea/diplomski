private static final int NTHREADS = 300;
private static AtomicInteger n = new AtomicInteger();

public static void main(String[] argv) throws InterruptedException {
    final CountDownLatch cdl = new CountDownLatch(NTHREADS);
    for (int i = 0; i < NTHREADS; i++) {
        new Thread(new Runnable() {
            public void run() {
                n.incrementAndGet();
                cdl.countDown();
            }
        }).start();
    }
    cdl.await();
    System.out.println("fxxk, n is: " + n);
}