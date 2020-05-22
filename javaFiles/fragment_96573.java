ThreadFactory threadFactory = new ThreadFactory() {
    public Thread newThread(final Runnable r) {
        return Executors.defaultThreadFactory().newThread(new Runnable(){
            public void run() {
                MDC.put(ORIG_LOG_FILE_NAME, fileName);
                r.run();
            }
        });
    }
};