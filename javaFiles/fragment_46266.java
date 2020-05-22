private static PublicKey readPublicKey() throws SomeException {
    InputStream in = new FileInputStream(PUBLIC_KEY_FILE);
    ObjectInputStream oin =
            new ObjectInputStream(new BufferedInputStream(in));
    try {
        BigInteger m = (BigInteger) oin.readObject();
        BigInteger e = (BigInteger) oin.readObject();
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        PublicKey pubKey = fact.generatePublic(keySpec);
        return pubKey;
    } catch (Exception e) {
        throw new SomeException(e);
    } finally {
        oin.close();
    }
}