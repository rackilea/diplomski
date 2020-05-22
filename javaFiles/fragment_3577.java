public byte[] signMobileConfig(byte[] mobileconfig) 
        throws CertificateEncodingException, PEMException, FileNotFoundException, IOException, CertificateException, OperatorCreationException, CMSException {
    Security.addProvider(new BouncyCastleProvider());

    X509CertificateHolder caCertificate = loadCertfile();

    JcaX509CertificateConverter certificateConverter = new JcaX509CertificateConverter();
    X509Certificate serverCertificate = certificateConverter.getCertificate(loadSigner());

    PrivateKeyInfo privateKeyInfo = loadInKey();
    PrivateKey inKey = new JcaPEMKeyConverter().getPrivateKey(privateKeyInfo);
    ContentSigner sha1Signer = new JcaContentSignerBuilder("SHA1withRSA").setProvider("BC").build(inKey);

    CMSSignedDataGenerator generator = new CMSSignedDataGenerator();
    JcaDigestCalculatorProviderBuilder digestProviderBuilder = new JcaDigestCalculatorProviderBuilder().setProvider("BC");
    JcaSignerInfoGeneratorBuilder generatotBuilder = new JcaSignerInfoGeneratorBuilder(digestProviderBuilder.build());

    generator.addSignerInfoGenerator(generatotBuilder.build(sha1Signer, serverCertificate));
    generator.addCertificate(new X509CertificateHolder(serverCertificate.getEncoded()));
    generator.addCertificate(new X509CertificateHolder(caCertificate.getEncoded()));

    CMSProcessableByteArray bytes = new CMSProcessableByteArray(mobileconfig);
    CMSSignedData signedData = generator.generate(bytes, true);

    return signedData.getEncoded();
}