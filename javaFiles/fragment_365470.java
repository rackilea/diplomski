// creating a thread pool with 10 threads, max alive time is 1 seconds, and linked blocking queue for unlimited queuing of requests.
        // if you want to process with 100 threads then replace both instances of 10 with 100, rest can remain same...
        // this should be a singleton
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        // inside your getSalesUserData() method
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    SendEmailUtility.sendmail(emaildummy);
                } catch (IOException e) {
                    logger.error("failed", e);
                }
            }
        });