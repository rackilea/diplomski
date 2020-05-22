//In your Service Class
...
private ServiceHandler _serviceHandler;

@Override
public void onCreate() {
    HandlerThread thread = new HandlerThread("ServiceClassName");
    thread.start();

    // Threads looper holen und beim servicehandler benutzen
    serviceHandler = new ServiceHandler(thread.getLooper());
}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    //message ausm pool holen
    Message msg = _serviceHandler.obtainMessage();
    msg.arg1 = startId;
    serviceHandler.sendMessage(msg);
    return START_STICKY;
}

private class mRunnable implements Runnable {
    private volatile boolean _continueRunning = true;

    @Override
    public void run() {
        while (_continueRunning) { //Watches the variable
            synchronized (this) {
                try {
                    //do stuff
                    wait(1000);
                } catch (Exception e) {
                    //Purposefully left blank
                }
            }
        }
    }

    public void stopRunning() {
        _continueRunning = false;
        this.notify();
    }
}