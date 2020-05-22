//from SwingWorker.java (c) Sun Microsystems/Oracle 2009
executorService =
            new ThreadPoolExecutor(1, MAX_WORKER_THREADS,
                                   10L, TimeUnit.MINUTES,
                                   new LinkedBlockingQueue<Runnable>(),
                                   threadFactory);