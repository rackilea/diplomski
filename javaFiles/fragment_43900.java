/** Read a PKCS#8 format private key. */
private static PrivateKey readPrivateKey(InputStream input)
throws IOException, GeneralSecurityException {
    try {
        byte[] buffer = new byte[4096];
        int size = input.read(buffer);
        byte[] bytes = Arrays.copyOf(buffer, size);
        /* Check to see if this is in an EncryptedPrivateKeyInfo structure. */
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
        /*
         * Now it's in a PKCS#8 PrivateKeyInfo structure. Read its Algorithm
         * OID and use that to construct a KeyFactory.
         */
        ASN1InputStream bIn = new ASN1InputStream(new ByteArrayInputStream(spec.getEncoded()));
        PrivateKeyInfo pki = PrivateKeyInfo.getInstance(bIn.readObject());
        String algOid = pki.getPrivateKeyAlgorithm().getAlgorithm().getId();
        return KeyFactory.getInstance(algOid).generatePrivate(spec);
    } finally {
        input.close();
    }
}