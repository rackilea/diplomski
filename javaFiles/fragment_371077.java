void doSomeIOStuff() throws IOException
{
    InputStream is = null;

    try
    {
        is = new MyInputStream(...);
        // Do stuff
    }
    catch (IOException ioExc)
    {
        // Either just inform (poor decision, but good for illustration):
        ioExc.printStackTrace();
        // Or re-throw to delegate further on:
        throw new IOException(ioExc);
    }
    finally
    {
        if (is != null)
        {
            is.close();
        }
    }
}