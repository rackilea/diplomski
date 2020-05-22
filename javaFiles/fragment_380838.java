while(true)
{
    try
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);