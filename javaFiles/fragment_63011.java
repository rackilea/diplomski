@Configuration
public class RestClientConfig extends AbstractElasticsearchConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(RestClientConfig.class);

    private static final String CERT_FILE = "client.p12";
    private static final String CERT_PASSWORD = "topsecret";
    private static final String USER_NAME = "user";
    private static final String USER_PASS = "password";

    @Override
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:443")  // set the address of the Elasticsearch cluster
                .usingSsl(createSSLContext())  // use the SSLContext with the client cert
                .withBasicAuth(USER_NAME, USER_PASS)   // use the headers for authentication
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    private SSLContext createSSLContext() {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");

            KeyManager[] keyManagers = getKeyManagers();

            sslContext.init(keyManagers, null, null);

            return sslContext;
        } catch (Exception e) {
            LOG.error("cannot create SSLContext", e);
        }
        return null;
    }

    private KeyManager[] getKeyManagers()
            throws KeyStoreException, NoSuchAlgorithmException, IOException, CertificateException, UnrecoverableKeyException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CERT_FILE)) {
            KeyStore clientKeyStore = KeyStore.getInstance("PKCS12");
            clientKeyStore.load(inputStream, CERT_PASSWORD.toCharArray());

            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(clientKeyStore, CERT_PASSWORD.toCharArray());
            return kmf.getKeyManagers();
        }
    }

    @Bean
    @Primary
    public ElasticsearchOperations elasticsearchTemplate() {
        return elasticsearchOperations();
    }
}