private static void pause(long ms)
{
    try
    {
        Thread.sleep(ms);
    }
    catch (InterruptedException e)
    {
        Thread.currentThread().interrupt();
    }
}