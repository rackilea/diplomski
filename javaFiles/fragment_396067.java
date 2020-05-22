long periodInMicroseconds = 16667;
exec.scheduleAtFixedRate(new Runnable() {
    public void run() {
        //some code
    }
}, 0, periodInMicroseconds, TimeUnit.MICROSECONDS);