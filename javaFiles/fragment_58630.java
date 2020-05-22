// create latch with count of one (1)
CountDownLatch latch = new CountDownLatch(1);

// create instances of classes that implement Runnable
Waiter waiter = new Waiter(latch);
Worker worker = new Worker(latch);

// start threads
new Thread(waiter).start();
new Thread(worker).start();