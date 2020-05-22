class Job implements Runnable {
    public void run() {
        // work
    }
}

// create thread pool with 5 threads and blocking queue
ExecutorService exec = Executors.newFixedThreadPool(5);

// submit some work
for(int i = 0; i < 10; i++) {
   exec.submit(new Job());
}