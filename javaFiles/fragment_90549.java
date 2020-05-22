Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Caught exception: "+e.getClass().getName());
        // do something else useful here
    }
});