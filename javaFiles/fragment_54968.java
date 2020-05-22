@Bean
public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatSslCustomizer() {
    return tomcat -> tomcat.setSslStoreProvider(new SslStoreProvider() {

        @Override
        public KeyStore getKeyStore() throws Exception {
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            try (InputStream is = readStoreFromURL(new URI(keyStoreURL))) {
                keyStore.load(is, keyStorePassword.toCharArray());
            }
            return keyStore;
        }

        @Override
        public KeyStore getTrustStore() throws Exception {
            KeyStore truststore = KeyStore.getInstance(trustStoreType);
            try (InputStream is = readStoreFromURL(new URI(trustStoreURL))) {
                truststore.load(is, trustStorePassword.toCharArray());
            }
            return truststore;
        }

        private InputStream readStoreFromURL(URI uri) {
            // Download the stores as binary from the config server
        }

    });
}