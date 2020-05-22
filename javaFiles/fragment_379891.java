public void test1() throws InterruptedException {
    final ExecutorService service = Executors.newFixedThreadPool(5);
    final CountDownLatch latch = new CountDownLatch(10);

    for(int i = 0; i < 10; i++) {
        final int threadId = i;
        Callable<?> c = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                long waitUntil = (long) (System.currentTimeMillis() + (Math.random() * 5000));
                while(System.currentTimeMillis() < waitUntil);
                latch.countDown();
                System.out.println("Finished task " + threadId);
                return null;
            }
        };
        service.submit(c);
    }

    // Start a thread which will run when the others are finished.
    new Thread(new Runnable() {
        @Override
        public void run() {
            try { latch.await(); } catch (InterruptedException e) { }
            System.out.println("All finished");
        }
    }).start();

    // Carry on main thread....
    Thread.sleep(60000);
}