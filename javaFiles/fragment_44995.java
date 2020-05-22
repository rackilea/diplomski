public static PrivateKey keyToValue(byte[] pkcs8key)
    throw GeneralSecurityException {

    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(pkcs8key);
    KeyFactory factory = KeyFactory.getInstance("ECDSA");
    PrivateKey privateKey = factory.generatePrivate(spec);
    return privateKey;
}