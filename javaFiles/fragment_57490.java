try(ServerSocket ssock = new ServerSocket(...))
{
    ssock.setSoTimeout(10_000); // 10 second timeout
    while(true)
    {
        Socket csock = ssock.accept();
        methodToStartThreadThatHandlesClientSocket(csock);
    }
}
catch(SocketTimeoutException ste)
{
    //handle socket timeout
}
catch(Exception other)
{
    //handle other exceptions
}