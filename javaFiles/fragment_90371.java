private static final ThreadLocal<SecureRandom> random = ThreadLocal.withInitial(
    SecureRandom::new
);
private static final ThreadLocal<MockPSKTlsServer> server = ThreadLocal.withInitial(
    MockPSKTlsServer::new
);

...
public void run() {
    try (BufferedInputStream bis  = new BufferedInputStream(mSocket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(mSocket.getOutputStream());
        TlsServerProtocol proto  = new TlsServerProtocol(bis, bos, random.get())) {
        // Calling server.get() will get the instance dedicated to the current
        // thread, if no instance exists so far for this thread
        // new MockPSKTlsServer() will automatically be called then
        // affected to this thread for subsequent get's calls
        proto.accept(server.get());
        ...
    } catch (IOException e) {
        System.err.print(e);
    }
}