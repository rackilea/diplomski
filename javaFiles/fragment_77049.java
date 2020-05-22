public synchronized HttpContextImpl createContext (String path, HttpHandler handler) {
    if (handler == null || path == null) {
        throw new NullPointerException ("null handler, or path parameter");
    }
    HttpContextImpl context = new HttpContextImpl (protocol, path, handler, this);
    contexts.add (context);
    logger.config ("context created: " + path);
    return context;
}

public synchronized HttpContextImpl createContext (String path) {
    if (path == null) {
        throw new NullPointerException ("null path parameter");
    }
    HttpContextImpl context = new HttpContextImpl (protocol, path, null, this);
    contexts.add (context);
    logger.config ("context created: " + path);
    return context;
}