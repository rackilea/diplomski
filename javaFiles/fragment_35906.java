ThreadPoolExecutor pool = new ThreadPoolExecutor(
                5, 
                15, 
                15000, 
                TimeUnit.MILLISECONDS, 
                new ArrayBlockingQueue<Runnable>(100)
            );