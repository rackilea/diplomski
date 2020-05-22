private final class ServiceHandler extends Handler {
    private volatile boolean _continueRunning = true;

    public ServiceHandler(Looper looper) {
        super(looper);
    }

    public void stopRunning() {
        _continueRunning = false;
        this.notify(); //Interrupts the wait
    }

    @Override
    public void handleMessage(Message msg) {
        while (_continueRunning) { //Watches the variable
            Log.d(MainActivity.TAG, "Thread " + tring.valueOf(msg.arg1)
                                + " running: " + url.toExternalForm());

        synchronized (this) {
            try {
                //do stuff
                wait(1000);
            } catch (Exception e) {}
        }
    }
}