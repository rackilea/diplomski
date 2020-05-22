// BEGIN FIX to avoid certificate error, need to set this up in the code for cxf
String storePath = System.getProperty("javax.net.ssl.keyStore");
String storePassword = System.getProperty("javax.net.ssl.keyStorePassword");
String storeType = System.getProperty("javax.net.ssl.keyStoreType");
KeyStore keyStore = KeyStore.getInstance(storeType);
keyStore.load(new FileInputStream(storePath), storePassword.toCharArray());
KeyManagerFactory factory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
factory.init(keyStore, storePassword.toCharArray());
KeyManager[] keyManagers = factory.getKeyManagers();
Client client = ClientProxy.getClient(port);
HTTPConduit conduit = (HTTPConduit) client.getConduit();
conduit.setTlsClientParameters(new TLSClientParameters());
conduit.getTlsClientParameters().setKeyManagers(keyManagers);