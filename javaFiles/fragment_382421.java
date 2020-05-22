CMSEnvelopedDataGenerator enGen = new CMSEnvelopedDataGenerator();

    for (Certificate c : certs) {
        enGen.addRecipientInfoGenerator(
                new JceKeyTransRecipientInfoGenerator((X509Certificate) c));
    }
    OutputEncryptor encryptor =
            new JceCMSContentEncryptorBuilder(CMSAlgorithm.AES256_CBC).setProvider("BC").build();
    CMSEnvelopedData envelopedData = enGen.generate(new CMSProcessableByteArray(bos.toByteArray()),
            encryptor);