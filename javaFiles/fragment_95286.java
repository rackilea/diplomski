public class CustomHandler extends Handler
{
    @Override
    public void publish(LogRecord record)
    {
        // Re-direct log calls here (e.g. send record to Log4j2 logger).
    }

    @Override
    public void flush() 
    {
    }

    @Override
    public void close() throws SecurityException
    {
    }
}