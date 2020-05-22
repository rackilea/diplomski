String filename = System.getProperty("java.home") + "/lib/security/cacerts".replace('/', File.separatorChar);
        Set<X509Certificate> additionalCerts = new HashSet<X509Certificate>();
        FileInputStream is = new FileInputStream(filename);
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        String password = "changeit";
        keystore.load(is, password.toCharArray());

        // This class retrieves the most-trusted CAs from the keystore
        PKIXParameters params = new PKIXParameters(keystore);

        // Get the set of trust anchors, which contain the most-trusted CA certificates
        Iterator it = params.getTrustAnchors().iterator();
        while( it.hasNext() ) {
            TrustAnchor ta = (TrustAnchor)it.next();
            // Get certificate
            X509Certificate cert = ta.getTrustedCert();
            additionalCerts.add(cert);
        }