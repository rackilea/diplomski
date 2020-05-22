System.setProperty("javax.net.ssl.keyStoreType", "pkcs12");
System.setProperty("javax.net.ssl.trustStoreType", "jks");
System.setProperty("javax.net.ssl.keyStore","C:/ClientKeyStore/ClientKeyStore.p12");
System.setProperty("javax.net.ssl.trustStore","C:/ClientKeyStore/ClientKeyStore.keystore");
System.setProperty("javax.net.debug", "ssl");
System.setProperty("javax.net.ssl.keyStorePassword", "keystorepass");
System.setProperty("javax.net.ssl.trustStorePassword", "truststorepass");


SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();