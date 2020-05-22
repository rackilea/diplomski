new ThreadPoolExecutor(5, 
                       5, 
                       2000L, 
                       TimeUnit.MILLISECONDS, 
                       new ArrayBlockingQueue<Runnable>(5, true), 
                       new ThreadPoolExecutor.CallerRunsPolicy());