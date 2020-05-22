// Regular Exception
Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());

// EDT Exception
SwingUtilities.invokeAndWait(new Runnable()
{
    public void run()
    {
        // We are in the event dispatching thread
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
    }
});