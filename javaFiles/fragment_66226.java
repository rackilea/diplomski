private static String password="jkzhsmzku";//the password you set in the storepass
private static String alias="business"//this is the alias;

private static Credential getCredential(){
    char[] pass=password.toCharArray();
    KeyStore ks=KeyStore.getInstance(KeyStore.getDefaultType());
    FileInputStream fis=new FileInputStream("pathToFile/fileName.csr");
    ks.load(fis, pass);
    KeyStore.PrivateKeyEntry pkEntry=null;
    pkEntry=(PrivateKeyEntry) ks.getEntry(alias,new KeyStore.PasswordProtection(password.toCharArray()));
    PrivateKey pk=pkEntry.getPrivateKey();
    X509Certificate certificate=(X509Certificate) pkEntry.getCertificate();
    BasicX509Credential basicCredential=new BasicX509Credential(certificate);
    basicCredential.setPrivateKey(pk);
    return basicCredential;
}