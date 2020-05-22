Executor executor = new ThreadPoolExecutor(/* core pool size */5,
        /* maximum pool size */10,
        /* keepAliveTime */1,
        /* time unit of keepAliveTime */TimeUnit.MINUTES,
        /* work queue */new ArrayBlockingQueue<Runnable>(10000),
        /* custom thread factory */new ThreadFactory() {
            private AtomicInteger counter = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, "asyncCaller-" + (counter.incrementAndGet()));
                return t;
            }
        },
        /*
         * policy applied when all tasks are occupied and task
         * queue is full.
         */new ThreadPoolExecutor.CallerRunsPolicy());