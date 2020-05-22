public final class ExceptionSuppressingRunnable implements Runnable
{
    private final Runnable original;

    public ExceptionSuppressingRunnable(Runnable runnable)
    {
        // TODO: Null validation
    }

    public void run()
    {
        try
        {
            original.run();
        }
        catch (RuntimeException e)
        {
            // TODO: Logging
        }
    }
}