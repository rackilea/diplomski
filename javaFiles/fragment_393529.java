// Used to release client1 
CountDownLatch startThread1 = new CountDownLatch(1);
Thread client2 = new Thread(
    () -> {
        System.out.println("Read 1");
        // Release client1
        startThread1.countDown();
    }
);
// Used to release client3
CountDownLatch startThread3 = new CountDownLatch(1);
Thread client1 = new Thread(
    () -> {
        try {
            // Waiting to be released
            startThread1.await();
            System.out.println("Read 2");
            // Release client3
            startThread3.countDown();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
);
Thread client3 = new Thread(
    () -> {
        try {
            // Waiting to be released
            startThread3.await();
            System.out.println("Read 3");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
);
// Start the threads in reverse order intentionally to show that 
// we still have the expected order
client3.start();
client1.start();
client2.start();