public
class Socket {

...

    public Socket(String host, int port)
    throws UnknownHostException, IOException
    {
    this(host != null ? new InetSocketAddress(host, port) :
         new InetSocketAddress(InetAddress.getByName(null), port),
         (SocketAddress) null, true);
    }


    public Socket(InetAddress address, int port) throws IOException {
    this(address != null ? new InetSocketAddress(address, port) : null, 
         (SocketAddress) null, true);
    }

...
}