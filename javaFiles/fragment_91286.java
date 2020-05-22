public PublicKey getPublic(String pubKey) throws Exception {
    byte[] publicBytes = Base64.decodeBase64(pubKey);
    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    return keyFactory.generatePublic(keySpec);
}