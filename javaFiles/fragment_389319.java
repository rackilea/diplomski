KeyStore root = KeyStore.getInstance("KeychainStore", "Apple");
        root.load(null);
        /* certificate must be DER-encoded */
        FileInputStream in = new FileInputStream("yourcertificate.cer");
        X509Certificate cacert = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(in);
        root.setCertificateEntry("certificatealiasname", cacert);
        root.store(null, null);