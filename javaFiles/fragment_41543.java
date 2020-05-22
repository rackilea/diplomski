class Test
{
    private final AtomicInteger fooUsers = new AtomicInteger();

    void foo()
    {
        fooUsers.incrementAndGet();
        try
        {
            // do stuff
        }
        finally
        {
            fooUsers.decrementAndGet();
        }
    }

    // is the method invoked by one or more threads
    boolean isFooBeingExecuted()
    {
        return fooUsers.get() > 0;
    }

    // is the method invoked by 2 or more threads (parallel)
    boolean isFooBeingExecutedInParallel()
    {
        return fooUsers.get() > 1;
    }
}