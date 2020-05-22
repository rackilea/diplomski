final SslContextFactory sslContextFactory = new SslContextFactory(sKeyStore);
sslContextFactory.setKeyStorePassword(sPassword);

final SslSocketConnector conn = new SslSocketConnector(sslContextFactory);
conn.setReuseAddress(true);
// ...