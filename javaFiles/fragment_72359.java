SslContextFactory sslContextFactory = new SslContextFactory();
sslContextFactory.setKeyStoreResource(Resource.newResource(urlKeyStore));
sslContextFactory.setKeyStorePassword(credential);
sslContextFactory.setExcludeCipherSuites(
        "SSL_RSA_WITH_DES_CBC_SHA",
        "SSL_DHE_RSA_WITH_DES_CBC_SHA",
        "SSL_DHE_DSS_WITH_DES_CBC_SHA",
        "SSL_RSA_EXPORT_WITH_RC4_40_MD5",
        "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA",
        "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA",
        "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
sslContextFactory.setExcludeProtocols("");