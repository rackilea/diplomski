static final int PORT = Integer.getInteger("port", 65432);
public static void main(String[] args) {
    if (args.length > 0) {
        new Socket("localhost", PORT);
        return;
    }

    try {
        log.debug("Starting server...");
        StompServer<MockStompProvider> server = new StompServer<MockStompProvider>();
        server.setStompProvider( new MockStompProvider() );
        server.addConnector( new InsecureConnector() );
        server.start();
        new ServerSocket(PORT).accept();

    } catch (Exception ex) {
        log.error("Exception ", ex);
    }
}