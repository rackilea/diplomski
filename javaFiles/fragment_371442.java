@Value("${server.ssl.trust-store}")
String trustStorePath;
@Value("${server.ssl.trust-store-password}")
String trustStorePass;
@Value("${server.ssl.key-store}")
String keyStorePath;
@Value("${server.ssl.key-store-password}")
String keyStorePass;

@Bean
public WebClient create2WayTLSWebClient() {

    ClientHttpConnector connector = new ReactorClientHttpConnector(
            options -> {
                options.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
                options.sslContext(get2WaySSLContext());
            }
    );

    return WebClient.builder()
            .clientConnector(connector)
            .build();

}

private SslContext get2WaySSLContext() {

    try {

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(new FileInputStream(ResourceUtils.getFile(keyStorePath)), keyStorePass.toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(keyStore, keyStorePass.toCharArray());

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(new FileInputStream(ResourceUtils.getFile(trustStorePath)), trustStorePass.toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
        trustManagerFactory.init(trustStore);

        return SslContextBuilder.forClient()
                .keyManager(keyManagerFactory)
                .trustManager(trustManagerFactory)
                .build();

    } catch (Exception e) {
        logger.error("Error creating 2-Way TLS WebClient. Check key-store and trust-store.");
        e.printStackTrace();
    }

    return null;
}