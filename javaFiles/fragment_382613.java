class YourLooperThread extends Thread
{
    // make it accessible from the outside
    private Handler handler;

    @Override public void run()
    {
        Looper.prepare();

        // Customize your handler, it has to be used in any thread which want to push a message in this thread's looper message Queue
        handler = new Handler();

        Looper.loop();
    }
}