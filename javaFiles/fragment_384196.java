private class clientconnection  extends Thread
{
    public void run()
    {
        try
        {
            // Set host name and port//
            hostname = "localhost"; //<---- Change this to server IP address
            port = 16666;