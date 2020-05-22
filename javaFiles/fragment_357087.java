final static Semaphore lock = new Semaphore(1);

public void runJob(String desc, Callable job, boolean wait) {
    logger.info("Acquiring lock");
    if (!lock.tryAcquire()) {
        throw new MyConcurrentJobException();
    }

    startThread(new Runnable() {
        public void run() {
            try {
                job.call();
            } finally {
                lock.release();
            }
        }
    });    
}