ThreadPoolExecutor pool = new ThreadPoolExecutor(
                15, 
                15, 
                15000, 
                TimeUnit.MILLISECONDS, 
                new ArrayBlockingQueue<Runnable>(100)
            );