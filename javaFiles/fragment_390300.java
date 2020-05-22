public Foo()
    {
        synchronized(this)
        {
            datagramSocket = createSocket();
        }
    }

private DatagramSocket createSocket() {
        try
        {
            return new DatagramSocket(DEFAULT_UDPLISTENPORT);
        }
        catch (SocketException e)
        {
            logger.error("Trouble opening UDP port: ", e);
            return null;  //I beg you, don't return null here...
        }
 }