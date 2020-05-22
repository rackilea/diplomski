/* context will be null for new connections */
context = connection.getHttpContext();
boolean newconnection;
SSLEngine engine = null;
String requestLine = null;
SSLStreams sslStreams = null;
try {
    if(context != null) {
        this.rawin = connection.getInputStream();
        this.rawout = connection.getRawOutputStream();
        newconnection = false;
    } else {
        /* figure out what kind of connection this is */
        newconnection = true;
        if(https) {
            if(sslContext == null) {
                logger.warning("SSL connection received. No https contxt created");
                throw new HttpError("No SSL context established");
            }
            sslStreams = new SSLStreams(ServerImpl.this, sslContext, chan);
            rawin = sslStreams.getInputStream();
            rawout = sslStreams.getOutputStream();
            engine = sslStreams.getSSLEngine();
            connection.sslStreams = sslStreams;
        } else {
            rawin = new BufferedInputStream(new Request.ReadStream(ServerImpl.this, chan));
            rawout = new Request.WriteStream(ServerImpl.this, chan);
        }
        connection.raw = rawin;
        connection.rawout = rawout;
    }
    Request req = new Request(rawin, rawout);
    requestLine = req.requestLine();
[...]