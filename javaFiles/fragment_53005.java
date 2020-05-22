@Override
public void execute(JobExecutionContext context)
        throws JobExecutionException
{
    runningThread = new AtomicReference<Thread>();
    try {
        this.runningThread.set(Thread.currentThread());
        reallyExecute(context);
    } finally { 
        runningThread.set(null); 
    }
}