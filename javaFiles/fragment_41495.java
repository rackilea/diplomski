private HttpsURLConnection prepRequest(String url, Iterable<Header> headers) throws IOException
{
    URL urlObject = new URL(null, url, new sun.net.www.protocol.https.Handler());
    HttpsURLConnection conn = (HttpsURLConnection) urlObject.openConnection(this.proxy);

    SSLConfig.apply(conn);
    conn.setConnectTimeout(DefaultTimeoutMillis);
    conn.setReadTimeout(DefaultTimeoutMillis);
    conn.setUseCaches(false);
    conn.setAllowUserInteraction(false);

    configureConnection(conn);

    for (Header header : headers) {
        conn.addRequestProperty(header.key, header.value);
    }

    return conn;
}