public static void testKeyStore() throws Exception {
  try {
    String storeName = "path/to/store";
    java.security.KeyPairGenerator keyPairGenerator = KeyPairGenerator
        .getInstance("RSA");
    keyPairGenerator.initialize(2048);
    KeyPair keyPair = keyPairGenerator.generateKeyPair();
    PublicKey publicKey = keyPair.getPublic();
    PrivateKey privateKey = keyPair.getPrivate();
    X509Certificate selfCert = createCertificate("CN=Client", "CN=Client",
        publicKey, privateKey);

    // Note: if you just want to store this certificate then write the
    // contents of selfCert.getEncoded() to file

    java.security.cert.Certificate[] outChain = { selfCert };
    KeyStore outStore = KeyStore.getInstance("PKCS12");
    outStore.load(null, PASSWORD.toCharArray());
    outStore.setKeyEntry("mykey", privateKey, PASSWORD.toCharArray(),
        outChain);
    OutputStream outputStream = new FileOutputStream(storeName);
    outStore.store(outputStream, PASSWORD.toCharArray());
    outputStream.flush();
    outputStream.close();

    KeyStore inStore = KeyStore.getInstance("PKCS12");
    inStore.load(new FileInputStream(storeName), PASSWORD.toCharArray());
  } catch (Exception e) {
    e.printStackTrace();
    throw new AssertionError(e.getMessage());
  }
}