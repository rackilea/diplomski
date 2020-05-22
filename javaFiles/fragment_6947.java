// initialization of your threads
Runnable[] runnables = new Runnable[5];
for (int i=0; i<5; i++) {
    runnables[i] = new MyRunnable(i);
}

// initialization of thread pool with fixed size 3
ExecutorService executor = Executors.newFixedThreadPool(3);
// passing the threads to the execution threads pool
for (Runnable a: runnables) {
    executor.execute(a);
}