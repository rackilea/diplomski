SSLContext sslcontext = SSLContexts
        .custom()
        .loadTrustMaterial(new File(KEYSTORE_PATH), KEYSTORE_PASSWORD,
                new TrustSelfSignedStrategy()).build();

SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
        sslcontext, NoopHostnameVerifier.INSTANCE);

final Registry<ConnectionSocketFactory> registry = RegistryBuilder
        .<ConnectionSocketFactory> create()
        .register("http", new PlainConnectionSocketFactory())
        .register("https", sslsf).build();

final PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(
        registry);
cm.setMaxTotal(100);