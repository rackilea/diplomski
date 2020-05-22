new Thread(new Runnable() {
    @Override
    public void run() {
        SystemClock.sleep(Long.MAX_VALUE);
    }
}).start();