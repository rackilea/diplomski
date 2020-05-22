import org.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
...

    /**
     * Reads the Certificate from the file with filename.
     * Works for p7b-files.
     * @param filename the name and path of a key-file.
     * @return a Certificate
     */
    public static Certificate getCertificate(String filename) {
        Certificate cert = null;
        try (InputStream is = new FileInputStream(filename)) {
            CertificateFactory fact = new CertificateFactory();
            cert = fact.engineGenerateCertificate(is);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return cert;
    }