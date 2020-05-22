class SolveTimer implements Runnable
{
    private String buildData;
    private AtomicLong milliseconds = new AtomicLong(-1);

    public SolveTimer(String buildData)
    {
        assert buildData != null;
        this.buildData = buildData;
    }

    public void run()
    {
        long time = System.currentTimeMillis();
        // create the grid, solve the grid
        milliseconds.set(System.currentTimeMillis() - time);
    }

    public long getDuration() throws ContradictionException
    {
        return milliseconds.get();
    }
}