ServerSocket ss = null;
try {
    ss = new ServerSocket(0);
    PORT = ss.getLocalPort();
} catch (IOException e) {
    LOG.error("Socket Exception while opening socket:", e);
} finally {
    try {
        ss.close();
    } catch (IOException e) {
        LOG.error("Socket Exception while closing socket:", e);
    }
}