...
    char[] password = "123".toCharArray();
    ks.load(null, password);

    PrivateKeyEntry entry = new PrivateKeyEntry(pair.getPrivate(),
            new java.security.cert.Certificate[]{PKCertificate});
    ks.setEntry("hive",entry , new KeyStore.PasswordProtection("123".toCharArray()));

    fos = new FileOutputStream("hive-keystore.pkcs12");
    ks.store(fos, password);
    fos.close();