public static RSAPublicKey getPublicKey(File publicKeyFile) throws IOException, GeneralSecurityException {
    byte[] keyBytes = new byte[(int)publicKeyFile.length()];
    FileInputStream fis = new FileInputStream(publicKeyFile);
    fis.read(keyBytes);
    X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory factory = KeyFactory.getInstance("RSA");
    RSAPublicKey pubKey = (RSAPublicKey)factory.generatePublic(publicKeySpec);
    return pubKey;
}