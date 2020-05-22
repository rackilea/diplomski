ExecutorService threadPool = newFixedThreadPool(numThreads,
    new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            Thread thread = Executors.defaultThreadFactory().newThread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    });