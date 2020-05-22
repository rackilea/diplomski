HttpClientContext ctx = HttpClientContext.create();
HttpResponse response = getHttpClient().execute(method, ctx);

if(log.isDebugEnabled())
{
    ManagedHttpClientConnection connection = ctx.getConnection(ManagedHttpClientConnection.class);
    // Can be null if the response encloses no content
    if(null != connection)
    {
        Socket socket = connection.getSocket();
        if(socket instanceof SSLSocket)
        {
            SSLSocket sslSock = (SSLSocket)socket;
            log.debug("Connected to " + getEndpointURL()
                      + " using " + sslSock.getSession().getProtocol()
                      + " and suite " + sslSock.getSession().getCipherSuite());
        }
    }
}