private void synchronousHandshake(SSLSocket socket) throws IOException {
    InputStream in = socket.getInputStream();
    int oldTimeout = socket.getSoTimeout();
    socket.setSoTimeout(1000);
    byte[] b = new byte[0];
    listener.reset();
    socket.startHandshake();
    int maxTries = 60; // 60 * 1000 = example 1 minute time out
    for (int i = 0; i < maxTries; i++) {
        if (logger.isTraceEnabled())
            logger.trace("Reading for try #" + i);
        try {
            int x = in.read(b);
        } catch (SSLException sslex) {
            logger.info("SSL Error getting client Certs", sslex);
            throw sslex;
        } catch (IOException e) {
            // ignore - presumably the timeout
        }
        if (listener.completed) {
            break;
        }
    }
    socket.setSoTimeout(oldTimeout);
    if (listener.completed == false) {
        throw new SocketException("SSL Cert handshake timeout");
    }
}