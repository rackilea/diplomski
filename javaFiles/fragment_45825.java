// Get a handler that can be used to post to the main thread
Handler mainHandler = new Handler(Looper.getMainLooper());

Runnable myRunnable = new Runnable() {
    @Override 
    public void run() {....} // This is your code
};
mainHandler.post(myRunnable);