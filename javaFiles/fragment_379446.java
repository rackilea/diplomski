private ThreadPoolExecutor executor = 
        new ThreadPoolExecutor(1,1, 1, TimeUnit.SECONDS, 
             new SynchronousQueue(), new ThreadPoolExecutor.AbortPolicy());
    private Future<Void> lastSubmitted;
    private ReentrantLock submissionLock = new ReentrantLock();
    ...


    try {
      submissionLock.lock();
      Future<Void> future = 
        executor.submit(new MyAsyncTask()); // assuming this implements Callable<Void>
      lastSubmitted = future;
    }
    catch (RejectedExecutionException e) {
      lastSubmitted.cancel();
      Future<Void> future = 
        executor.submit(new MyAsyncTask()); // assuming this implements Callable<Void>
      lastSubmitted = future;

    }
    finally {
      submissionLock.unlock();
    }