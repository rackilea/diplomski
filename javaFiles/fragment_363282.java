public static RSAPrivateKey getPrivateKey(File privateKeyFile) throws IOException, GeneralSecurityException {
    byte[] keyBytes = new byte[(int)privateKeyFile.length()];
    FileInputStream fis = new FileInputStream(privateKeyFile);
    fis.read(keyBytes);
    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    RSAPrivateKey privKey = (RSAPrivateKey) keyFactory.generatePrivate(spec);
    return privKey;
}