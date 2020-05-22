@WebEndpoint(name = "MyWebServicePort")
public IMyWebService getMyWebServicePort() {
    IMyWebService port = super.getPort(new QName("http://my.namespace/", "MyWebServicePort"), IMyWebService.class);
    try {
        // loads keymanager
        File keyStoreFile = new File(System.getProperty("javax.net.ssl.keyStore"));
        String keyStorePass = System.getProperty("javax.net.ssl.keyStorePassword");

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(keyStoreFile), keyStorePass.toCharArray());

        KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyFactory.init(keyStore, keyStorePass.toCharArray());

        KeyManager[] km = keyFactory.getKeyManagers();


        // loads trustmanager
        File trustStoreFile = new File(System.getProperty("javax.net.ssl.trustStore"));
        String trustStorePass = System.getProperty("javax.net.ssl.trustStorePassword");

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new FileInputStream(trustStoreFile), trustStorePass.toCharArray());

        TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustFactory.init(trustStore);

        TrustManager[] tm = trustFactory.getTrustManagers();

        // configuring the connection
        Client cxfClient = ClientProxy.getClient(port);
        HTTPConduit httpConduit = (HTTPConduit) cxfClient.getConduit();

        TLSClientParameters tlsParams = httpConduit.getTlsClientParameters();
        if (tlsParams == null) {
            tlsParams = new TLSClientParameters();
        }
        tlsParams.setKeyManagers(km);
        tlsParams.setTrustManagers(tm);

        httpConduit.setTlsClientParameters(tlsParams);
    } catch (Exception e) {
        ...
    }

    return port;
}