ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1,
    TimeUnit.MINUTES, new LinkedBlockingQueue<>()) {
        @Override protected void afterExecute(Runnable r, Throwable t) {
            if(t!=null) synchronized(System.out) {
               System.out.println("Uncaught exception in "+Thread.currentThread().getId());
               t.printStackTrace(System.out);
            }
        }
    };