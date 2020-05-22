private class CustomNetworkClient extends sun.net.NetworkClient
{

    public CustomNetworkClient(int readTimeout)
    {
        defaultSoTimeout = readTimeout;

    }

}