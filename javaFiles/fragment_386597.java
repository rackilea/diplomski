public static void rebind(String name, Remote obj) throws RemoteException, MalformedURLException 
    ParsedNamingURL parsed = parseURL(name);
    Registry registry = getRegistry(parsed);
    if (obj == null)
        throw new NullPointerException("cannot bind to null");
    registry.rebind(parsed.name, obj);
}
...

private static Registry getRegistry(ParsedNamingURL parsed) throws RemoteException {
    return LocateRegistry.getRegistry(parsed.host, parsed.port);
}