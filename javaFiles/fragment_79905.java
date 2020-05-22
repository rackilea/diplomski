public static Registry getRegistry(String host, int port, RMIClientSocketFactory csf) throws RemoteException
{
    Registry registry = null;

    if (port <= 0)
        port = Registry.REGISTRY_PORT;

    if (host == null || host.length() == 0) {
        // If host is blank (as returned by "file:" URL in 1.0.2 used in
        // java.rmi.Naming), try to convert to real local host name so
        // that the RegistryImpl's checkAccess will not fail.
        try {
            host = java.net.InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            // If that failed, at least try "" (localhost) anyway...
            host = "";
        }
    }

    LiveRef liveRef = new LiveRef(new ObjID(ObjID.REGISTRY_ID), new TCPEndpoint(host, port, csf, null), false);
    RemoteRef ref = (csf == null) ? new UnicastRef(liveRef) : new UnicastRef2(liveRef);

    return (Registry) Util.createProxy(RegistryImpl.class, ref, false);
}