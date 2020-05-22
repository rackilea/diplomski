SSLcontext sslContext = SSLContext.getDefault();

KeyStore trustSt = KeyStore.getInstance("BKS");
TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
InputStream trustStoreStream = this.getResources().openRawResource(R.raw.truststore);
trustSt.load(trustStoreStream, "<yourpassword>".toCharArray());
trustManagerFactory.init(trustStre);

KeyStore keyStore = KeyStore.getInstance("BKS");
KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
InputStream keyStoreStream = this.getResources().openRawResource(R.raw.keystore);
keyStore.load(keyStoreStream, "<yourpassword>".toCharArray());
keyManagerFactory.init(keyStore, "<yourpassword>".toCharArray());

sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);