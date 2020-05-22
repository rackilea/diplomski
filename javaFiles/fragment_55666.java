Handler mainHandler = new Handler(context.getMainLooper());

Runnable myRunnable = new Runnable() {
    @Override 
    public void run() {
        // Your code
    }  
};
mainHandler.post(myRunnable);