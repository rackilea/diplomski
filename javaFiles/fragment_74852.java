synchronized public void flush()
        throws IOException
    {
    // out.flush() do not work on an empty SPDY output stream!!!
    // it ends with:
    // java.lang.IllegalStateException: not lastContent, no content and no responseInfo!
    //    at org.eclipse.jetty.spdy.server.http.HttpTransportOverSPDY.send(HttpTransportOverSPDY.java:164)
    // this is a reason for "flushed" variable
    if (flushed)
        return;
    out.flush();
    flushed = true;
    } // flush