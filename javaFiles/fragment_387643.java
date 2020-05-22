String addr = "239.192.1.1";
int port = 22224;
int ttl = 32;

SessionAddress multiAddress =
    new SessionAddress(InetAddress.getByName(addr), port, ttl);
SessionAddress localAddress = 
    new SessionAddress(InetAddress.getLocalHost(), SessionAddress.ANY_PORT, ttl);
SessionAddress multiAny = 
    new SessionAddress(InetAddress.getByName(addr), port, ttl);