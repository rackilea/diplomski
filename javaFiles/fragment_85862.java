public void someMethod()
{
    new Thread(new MyRunnable()).start();
}

// ... several methods down ... //

class MyRunnable implements Runnable
{
    public void run()
    {
        // do stuff
    }
}