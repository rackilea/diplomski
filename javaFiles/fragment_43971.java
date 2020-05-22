KeyStore keyStore = KeyStore.getInstance("jks");
try (InputStream in = YourClassName.class.getResourceAsStream("AAAWSKeyStore.jks")) {
    keyStore.load(in, "password".toCharArray());
}

SslConfigurator sslConfig = SslConfigurator.newInstance()
    .trustStore(keyStore)
    .keyStore(keyStore)
    .securityProtocol("TLS");