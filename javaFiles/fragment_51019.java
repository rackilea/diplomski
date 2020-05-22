while (!stopped) {
    CountDownLatch latch = new CountDownLatch(N);
    // create and start your threads
    latch.await(); // this method blocks until each Thread calls countDown()
    // wait here 5 seconds if you want
}