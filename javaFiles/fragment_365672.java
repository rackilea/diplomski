Thread t1 = new Thread(() -> {
    // do service call
    try {
        // your code here
    } catch (Exception e) {

    }
    latch.countDown();
});