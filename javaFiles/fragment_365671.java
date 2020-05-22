CountDownLatch latch = new CountDownLatch(2);
Thread t1 = new Thread(() -> {
    // do service call and update the response object 
    latch.countDown();
});
Thread t2 = new Thread(() -> {
    // do database call and update the response object 
    latch.countDown();
});

t1.start();
t2.start();

latch.await(); // main thread will wait here for the completion of T1 & T2 thread.