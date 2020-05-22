private Object mutex = new Object();
private boolean yourTaskIsRunning = false;

protected void yourTask()
{
    synchronized(mutex)
    {
        if (yourTaskIsRunning) return;
        yourTaskIsRunning = true;
    }
    try
    {
        // do your thing
    }
    finally
    {
        yourTaskIsRunning = false;
    }
}