private void setUp() {
    mHandlerThread = new CustomThread("foo", Process.THREAD_PRIORITY_BACKGROUND);
    mHandlerThread.start();

    // Create our handler; this will block until looper is initialised
    mHandler = new CustomHandler(mHandlerThread.getLooper());
    // mHandler is now ready to use
}

private class CustomThread extends HandlerThread {
    public void run() {
        // ...
    }
}   

private class CustomHandler extends Handler {
    CustomHandler(Looper looper) {
        super(looper);
    }

    @Override
    public void handleMessage(Message msg) {
        // ...
    }
}