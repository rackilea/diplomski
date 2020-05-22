/**
 * Create new Certificate Authority.
 * @param keyAlgorithm key algorithm
 * @param keyLength key length
 * @param storePassword store password
 * @param keyPassword private key password
 * @param alias alias in key store
 * @param signatureAlgorithm signature algorithm
 * @param issuer issuer
 * @param validFrom certificate validity first date
 * @param validTo certificate validity last date
 * @return KeyStore with the certificate and private key
 * @throws GeneralSecurityException 
 */
public static KeyStore createCertificateAuthority(String keyAlgorithm, int keyLength, char[] storePassword, char[] keyPassword, String alias,
        String signatureAlgorithm, String issuer, Date validFrom, Date validTo)
        throws GeneralSecurityException {
    String subject = issuer;
    String subjectAltName = null;
    String subjectIPAddress = null;//"127.0.0.1";
    KeyPair keyPair = SecurityUtils.generateKeyPair(keyAlgorithm, keyLength);
    X509Certificate x509Certificate = CertificateUtils.generateV3Certificate(
            new X500Principal(issuer), new X500Principal(subject),
            false, false, subjectAltName, subjectIPAddress,
            keyPair.getPublic(), keyPair.getPrivate(), validFrom, validTo, signatureAlgorithm);
    x509Certificate.checkValidity(new Date());
    x509Certificate.verify(keyPair.getPublic());

    X509Certificate[] chain = new X509Certificate[1];
    chain[0] = x509Certificate;
    KeyStore keyStoreSigningKey = SecurityUtils.createKeyStore(storePassword);
    keyStoreSigningKey.setKeyEntry(alias, keyPair.getPrivate(), keyPassword, chain);
    return keyStoreSigningKey;
}

/**
 * Generate RCA 1024bit private and public keys pair
 * 
 * @param algorithm the standard string name of the algorithm. i.e. "RSA"
 * @param keySize algorithm-specific metric, such as modulus length, specified in number of bits. i.e. 1024,2048,4096 for RSA
 * @return
 * @throws NoSuchAlgorithmException
 */
public static KeyPair generateKeyPair(String algorithm, int keySize) throws NoSuchAlgorithmException {
    KeyPairGenerator kpg = KeyPairGenerator.getInstance(algorithm);
    kpg.initialize(keySize);
    return kpg.generateKeyPair();
}

/**
 * Create new key store
 * 
 * @param storePassword
 * @return
 * @throws KeyStoreException
 * @throws NoSuchAlgorithmException
 * @throws CertificateException
 */
public static KeyStore createKeyStore(char[] storePassword) throws KeyStoreException, NoSuchAlgorithmException, CertificateException {
    // Instantiate KeyStore
    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

    // Load keystore
    try {
        keyStore.load(null, storePassword);
    } catch (IOException e) { //theoretically should never happen
        throw new KeyStoreException(e);
    }

    return keyStore;
}