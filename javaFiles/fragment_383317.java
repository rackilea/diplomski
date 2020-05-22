public final Thread newThread(final Runnable r) {
    Thread newThread = threadFactory.newThread(r); // you can use default thread factory
    newThread.setName("threadName");
    newThread.setDaemon(Boolean.TRUE);
    newThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(final Thread t, final Throwable e) {
            // log
        }
    });
    return newThread;
}