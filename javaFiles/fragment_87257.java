public void createKeyStore(String keyStorePwd, String keyStoreFile,
    PrivateKey privateKey, X509Certificate certificate)
    throws Exception {

    char[] pwd = keyStorePwd.toCharArray();

    KeyStore ks = KeyStore.getInstance("PKCS12");
    ks.load(null, pwd);

    KeyStore.ProtectionParameter protParam =
        new KeyStore.PasswordProtection(pwd);
    Certificate[] certChain =
        new Certificate[]{ certificate };
    KeyStore.PrivateKeyEntry pkEntry =
        new KeyStore.PrivateKeyEntry(privateKey, certChain);
    ks.setEntry("keypair", pkEntry, protParam);

    FileOutputStream fos = new FileOutputStream(keyStoreFile);
    ks.store(fos, pwd);
    fos.close();
}