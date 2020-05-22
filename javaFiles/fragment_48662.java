HttpClientBuilder builder = HttpClientBuilder.create();
SSLConnectionSocketFactory sslConnectionFactory = new SSLConnectionSocketFactory(context, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
builder.setSSLSocketFactory(sslConnectionFactory);

Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
        .register("https", sslConnectionFactory)
        .build();

HttpClientConnectionManager ccm = new BasicHttpClientConnectionManager(registry);

builder.setConnectionManager(ccm);

return builder.build();