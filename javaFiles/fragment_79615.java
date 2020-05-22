class X
{
    private BlockingQueue taskQueue;

    public X()
    {
        taskQueue = new BlockingQueue();
    }

    public BlockingQueue getQueue()
    {
        return taskQueue;
    }
}