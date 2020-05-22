/**
 * Creates a new key pair and self-signed certificate.
 * example params: keyAlgName = "RSA", sigAlgName = "SHA1WithRSA", keysize = 2048
 * Example: x500Name=new X500Name(commonName, organizationalUnit, organization, city, state, country);
 * @param keyStore
 * @param alias
 * @param keyPass 
 * @param keyAlgName 
 * @param sigAlgName 
 * @param keysize 
 * @param principal 
 * @param startDate 
 * @param validityDays 
 * @return KeyStore object
 * @throws Exception  
 */
public static KeyStore generateKeyPair(KeyStore keyStore, String alias, char[] keyPass,
        String keyAlgName, String sigAlgName, int keysize,
        X500Principal principal, Date startDate, int validityDays)
        throws Exception {
    KeyStore keyStore2 = keyStore;
    if (keyStore2 == null) {
        keyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore2.load(null, null);
    }

    if (keyStore2.containsAlias(alias)) {
        MessageFormat form = new MessageFormat("Key pair not generated, alias <alias> already exists");
        Object[] source = {alias};
        throw new Exception(form.format(source));
    }

    X509Certificate[] chain = new X509Certificate[1];

    //CertAndKeyGen keyPair = new CertAndKeyGen(keyAlgName, sigAlgName);
    //keyPair.generate(keysize);
    //X500Name x500Name=new X500Name(commonName, organizationalUnit, organization, city, state, country);
    //chain[0] = keyPair.getSelfCertificate(x500Name, startDate, (long)validityDays*24*3600);
    KeyPair keyPair = SecurityUtils.generateKeyPair(keyAlgName, keysize);
    GregorianCalendar cal = new GregorianCalendar();
    cal.setTime(startDate);
    cal.add(Calendar.DATE, validityDays);
    Date endDate = cal.getTime();
    chain[0] = generateV3Certificate(principal, principal, false, true, null, null, keyPair.getPublic(), keyPair.getPrivate(), startDate, endDate, sigAlgName);

    keyStore2.setKeyEntry(alias, keyPair.getPrivate(), keyPass, chain);
    return keyStore2;
}

/**
 * Generate V3 Certificate.
 * @param issuer issuer
 * @param subject subject
 * @param useForServerAuth use for server auth flag
 * @param useForClientAuth use for client auth flag
 * @param subjectAltName subject alt name
 * @param subjectIPAssress subject IP address
 * @param publicKey public key
 * @param privateKey private key
 * @param from certificate validity first date
 * @param to certificate validity last date
 * @param signatureAlgorithm signature algorithm
 * @return X509Certificate object
 * @throws GeneralSecurityException GeneralSecurityException
 */
public static X509Certificate generateV3Certificate(X500Principal issuer, X500Principal subject,
        boolean useForServerAuth, boolean useForClientAuth,
        String subjectAltName, String subjectIPAssress, PublicKey publicKey, PrivateKey privateKey,
        Date from, Date to, String signatureAlgorithm) throws GeneralSecurityException {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();

    certGen.setSerialNumber(new BigInteger(UUID.randomUUID().toString().replaceAll("-", ""), 16));
    certGen.setSubjectDN(subject);
    certGen.setIssuerDN(issuer);
    certGen.setNotBefore(from);
    certGen.setNotAfter(to);
    certGen.setPublicKey(publicKey);
    certGen.setSignatureAlgorithm(signatureAlgorithm);

    certGen.addExtension(X509Extensions.BasicConstraints, true, issuer.equals(subject) ? new BasicConstraints(1) : new BasicConstraints(false));
    if (!issuer.equals(subject)) {
        certGen.addExtension(X509Extensions.KeyUsage, true, new KeyUsage(KeyUsage.digitalSignature
                | KeyUsage.keyEncipherment | (useForServerAuth ? KeyUsage.keyCertSign | KeyUsage.cRLSign : 0)));
    }
    if (useForServerAuth) {
        certGen.addExtension(X509Extensions.ExtendedKeyUsage, true, new ExtendedKeyUsage(KeyPurposeId.id_kp_serverAuth));
    }
    if (useForClientAuth) {
        certGen.addExtension(X509Extensions.ExtendedKeyUsage, true, new ExtendedKeyUsage(KeyPurposeId.id_kp_clientAuth));
    }
    if (subjectAltName != null) {
        certGen.addExtension(X509Extensions.SubjectAlternativeName, false, new GeneralNames(
                new GeneralName(GeneralName.rfc822Name, subjectAltName)));
    }
    if (subjectIPAssress != null) {
        certGen.addExtension(X509Extensions.SubjectAlternativeName, true, new GeneralNames(
                new GeneralName(GeneralName.iPAddress, subjectIPAssress)));
    }

    return certGen.generate(privateKey);
}