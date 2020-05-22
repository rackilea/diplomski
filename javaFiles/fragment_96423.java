if(canExport && fileCreated)
{
    //Create the file
    this.file.createNewFile();

    try
    {
        this.run();
    }
    catch (IOException e)
    {
        try
        {
            file.delete();
        }
        catch (IOException ignore) {} // don't want to mask the real exception

        // Rethrow the actual exception from run() so callers can handle it
        throw e;
    }
}