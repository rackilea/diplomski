// t is the parent code thread
t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

    public void uncaughtException(Thread t, Throwable e) {
       LOGGER.error(t + " throws exception: " + e);
    }
 });