Thread t = new Thread(new MyRunnable());
t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

    public void uncaughtException(Thread t, Throwable e) {
       LOGGER.error(t + " throws exception: " + e);
    }
});
t.start();

//outside that class
class MyRunnable implements Runnable(){
    public void run(){
        throw new RuntimeException("hey you!");
    }
}