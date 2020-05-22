KeyStore keyStore = KeyStore.getInstance("JKS");
FileInputStream fileInputStream = new FileInputStream("identity key store full path name");
keyStore.load(fileInputStream, "identity key store password".toCharArray());
KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
keyManagerFactory.init(keyStore, "identity key store password".toCharArray());
KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();
sc.init(keyManagers, trustAllCerts, new java.security.SecureRandom());