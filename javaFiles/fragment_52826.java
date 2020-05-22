KeyStore keystore = ... // create and load your keystore.

KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
kmf.init(keystore, password.toCharArray());

final X509KeyManager origKm = (X509KeyManager)kmf.getKeyManagers()[0];

X509KeyManager km = new X509KeyManager() {
    public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket) {
        return "foo";
    }

    public X509Certificate[] getCertificateChain(String alias) {
        return origKm.getCertificateChain(alias);
    }

    // Delegate the rest of the methods from origKm too...
}