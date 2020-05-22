public static void main( String[] args ) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, IllegalStateException, SignatureException, KeyStoreException, CertificateException, FileNotFoundException, IOException
{
    Security.addProvider(new BouncyCastleProvider());
    // yesterday
    Date validityBeginDate = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
    // in 2 years
    Date validityEndDate = new Date(System.currentTimeMillis() + 2 * 365 * 24 * 60 * 60 * 1000);

    // GENERATE THE PUBLIC/PRIVATE RSA KEY PAIR
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC");
    keyPairGenerator.initialize(1024, new SecureRandom());

    KeyPair keyPair = keyPairGenerator.generateKeyPair();

    // GENERATE THE X509 CERTIFICATE
    X509V1CertificateGenerator certGen = new X509V1CertificateGenerator();
    X500Principal dnName = new X500Principal("CN=" + "username");

    certGen.setSerialNumber(new BigInteger("100"));
    certGen.setSubjectDN(dnName);
    certGen.setIssuerDN(dnName); // use the same
    certGen.setNotBefore(validityBeginDate);
    certGen.setNotAfter(validityEndDate);
    certGen.setPublicKey(keyPair.getPublic());
    certGen.setSignatureAlgorithm("SHA256WithRSAEncryption");

    X509Certificate cert = certGen.generate(keyPair.getPrivate(), "BC");

    KeyStore clientKeystore = KeyStore.getInstance("PKCS12", "BC");

    clientKeystore.load(null, null);

    clientKeystore.setKeyEntry("mkey", keyPair.getPrivate(), null, new X509Certificate[] { cert });

    clientKeystore.store(new FileOutputStream("admin.pkcs"), "pass".toCharArray());
}