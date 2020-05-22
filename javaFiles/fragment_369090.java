String privKeyPEM = key.replace(
"-----BEGIN RSA PRIVATE KEY-----\n", "")
    .replace("-----END RSA PRIVATE KEY-----", "");

// Base64 decode the data

byte[] encodedPrivateKey = Base64.decode(privKeyPEM, Base64.DEFAULT);

try {
    ASN1Sequence primitive = (ASN1Sequence) ASN1Sequence
        .fromByteArray(encodedPrivateKey);
    Enumeration<?> e = primitive.getObjects();
    BigInteger v = ((DERInteger) e.nextElement()).getValue();

    int version = v.intValue();
    if (version != 0 && version != 1) {
        throw new IllegalArgumentException("wrong version for RSA private key");
    }
    /**
     * In fact only modulus and private exponent are in use.
     */
    BigInteger modulus = ((DERInteger) e.nextElement()).getValue();
    BigInteger publicExponent = ((DERInteger) e.nextElement()).getValue();
    BigInteger privateExponent = ((DERInteger) e.nextElement()).getValue();
    BigInteger prime1 = ((DERInteger) e.nextElement()).getValue();
    BigInteger prime2 = ((DERInteger) e.nextElement()).getValue();
    BigInteger exponent1 = ((DERInteger) e.nextElement()).getValue();
    BigInteger exponent2 = ((DERInteger) e.nextElement()).getValue();
    BigInteger coefficient = ((DERInteger) e.nextElement()).getValue();

    RSAPrivateKeySpec spec = new RSAPrivateKeySpec(modulus, privateExponent);
    KeyFactory kf = KeyFactory.getInstance("RSA");
    PrivateKey pk = kf.generatePrivate(spec);
} catch (IOException e2) {
    throw new IllegalStateException();
} catch (NoSuchAlgorithmException e) {
    throw new IllegalStateException(e);
} catch (InvalidKeySpecException e) {
    throw new IllegalStateException(e);
}