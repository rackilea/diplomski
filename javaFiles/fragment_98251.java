try {
    // Set up the socket address
    InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), config.getHttpsPort());

    // Initialise the HTTPS server
    HttpsServer httpsServer = HttpsServer.create(address, 0);
    SSLContext sslContext = SSLContext.getInstance("TLS");

    // Initialise the keystore
    char[] password = "simulator".toCharArray();
    KeyStore ks = KeyStore.getInstance("JKS");
    FileInputStream fis = new FileInputStream("lig.keystore");
    ks.load(fis, password);

    // Set up the key manager factory
    KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
    kmf.init(ks, password);

    // Set up the trust manager factory
    TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
    tmf.init(ks);

    // Set up the HTTPS context and parameters
    sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
    httpsServer.setHttpsConfigurator(new HttpsConfigurator(sslContext) {
        public void configure(HttpsParameters params) {
            try {
                // Initialise the SSL context
                SSLContext c = SSLContext.getDefault();
                SSLEngine engine = c.createSSLEngine();
                params.setNeedClientAuth(false);
                params.setCipherSuites(engine.getEnabledCipherSuites());
                params.setProtocols(engine.getEnabledProtocols());

                // Get the default parameters
                SSLParameters defaultSSLParameters = c.getDefaultSSLParameters();
                params.setSSLParameters(defaultSSLParameters);
            } catch (Exception ex) {
                ILogger log = new LoggerFactory().getLogger();
                log.exception(ex);
                log.error("Failed to create HTTPS port");
            }
        }
    });
    LigServer server = new LigServer(httpsServer);
    joinableThreadList.add(server.getJoinableThread());
} catch (Exception exception) {
    log.exception(exception);
    log.error("Failed to create HTTPS server on port " + config.getHttpsPort() + " of localhost");
}