final InMemoryDirectoryServerConfig cfg =
     new InMemoryDirectoryServerConfig("dc=example,dc=com",
          "o=example.com");
cfg.addAdditionalBindCredentials("cn=Directory Manager", "password");
cfg.addAdditionalBindCredentials("cn=Manager", "password");
cfg.setSchema(Schema.getDefaultStandardSchema());
cfg.setListenerExceptionHandler(
     new StandardErrorListenerExceptionHandler());

final SSLUtil serverSSLUtil = new SSLUtil(
     new KeyStoreKeyManager(keyStorePath, "password".toCharArray(),
          "JKS", "server-cert"),
     new TrustStoreTrustManager(trustStorePath));
final SSLUtil clientSSLUtil = new SSLUtil(new TrustAllTrustManager());

cfg.setListenerConfigs(InMemoryListenerConfig.createLDAPSConfig("LDAPS",
     null, 0, serverSSLUtil.createSSLServerSocketFactory(),
     clientSSLUtil.createSSLSocketFactory()));

final InMemoryDirectoryServer testDSWithSSL =
     new InMemoryDirectoryServer(cfg);
testDSWithSSL.startListening();