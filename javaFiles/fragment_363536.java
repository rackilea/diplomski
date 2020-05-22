private Handler mHandler;

private HandlerThread mHandlerThread;

public void startHandlerThread(){
    mHandlerThread = new HandlerThread("HandlerThread");
    mHandlerThread.start();
    mHandler = new Handler(mHandlerThread.getLooper());
}