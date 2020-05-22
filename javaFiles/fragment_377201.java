ASN1Sequence seq= 
     (ASN1Sequence) new ASN1InputStream(parentPubKey.getEncoded()).readObject();

  SubjectPublicKeyInfo parentPubKeyInfo = new SubjectPublicKeyInfo(seq);

  ContentSigner signer = new JcaContentSignerBuilder(algorithm).build(parentPrivKey);

  X509v3CertificateBuilder certBldr = 
     new JcaX509v3CertificateBuilder(
        parentCert, 
        serialNum,
        startDate, 
        endDate, 
        distName, 
        pubKey)
     .addExtension(
           new ASN1ObjectIdentifier("2.5.29.35"),
           false,
           new AuthorityKeyIdentifier(parentPubKeyInfo))
     .addExtension(
        new ASN1ObjectIdentifier("2.5.29.19"), 
        false,
        new BasicConstraints(false)) // true if it is allowed to sign other certs
     .addExtension(
        new ASN1ObjectIdentifier("2.5.29.15"),
        true,
        new X509KeyUsage(
           X509KeyUsage.digitalSignature |
           X509KeyUsage.nonRepudiation   |
           X509KeyUsage.keyEncipherment  |
           X509KeyUsage.dataEncipherment));

  // Build/sign the certificate.
  X509CertificateHolder certHolder = certBldr.build(signer);

  X509Certificate cert = new JcaX509CertificateConverter().setProvider(BC)
     .getCertificate(certHolder);