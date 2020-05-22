static class process_threaded implements Runnable {
    // Reference to an executor
    private final ExecutorService exec;
    // Reference to the job counter
    private final AtomicInteger jobCounter;
    // Request to process
    private queue_class request;

    process_threaded( ExecutorService exec, AtomicInteger counter, queue_class request) {
        this.exec = exec;
        this.jobCounter = counter;
        this.jobCounter.incrementAndGet(); // Assuming that you will always
                                           // submit the process_threaded to
                                           // the executor if you create it.
        this.request = request;
    }

    public run() {
        //get work and process **request**, if it work great then the solution goes elsewhere
        //otherwise, depending on the data, its either discarded or parts of are added back to the executor
        exec.submit( new process_threaded( exec, new queue_class(k, data_list) ) );

        // Can do some more work

        // Always run before returning: counter update and notify the launcher
        synchronized(jobCounter){
            jobCounter.decrementAndGet();
            jobCounter.notifyAll();
        }
    }
}