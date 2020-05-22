Handler mHandler = new Handler();//this must be ran on the UI thread.
....
mHandler.post(new Runnable(){
    public void run() {
        toBeLaunchedInASeparateThread();
    }
});