class MyLoop
{
    private int numChecks;

    private int delay;

    public MyLoop(int numChecks, int delay) {...}

    public void loopAndSleep(MyTask task)
    throws InterruptedException
    {
        // Update: It is important to set properly the order of the looping conditions, 
        // to stop invoking hasEnded() as soon as i<numChecks==false (Thaks to Simon Eismann).
        for (int i=0; i<numChecks && !task.hasEnded(); i++)
        {
            if (i < numChecks -1)
            {
                Thread.sleep(DELAY);
            }
        }
    }
}

interface MyTask
{
    public boolean hasEnded();
}