public class Main {
    private static final String CER_PATH = "**PATH_TO_SAVE_CERTIFICATES**";

    public static void main(String[] args) throws Exception {
        new File(CER_PATH).mkdirs();
        KeyStore ks = KeyStore.getInstance("Windows-ROOT", "SunMSCAPI");
        ks.load(null, null);
        Enumeration<String> en = ks.aliases();
        int n = 0;
        while (en.hasMoreElements()) {
            String aliasKey = en.nextElement();
            Certificate certificate = ks.getCertificate(aliasKey);
            saveCertificate(certificate, n++ + ". " + aliasKey);
        }
    }

    public static void saveCertificate(Certificate certificate, String name) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(CER_PATH + name + ".cer");
            fos.write(certificate.getEncoded());
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CertificateEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    // ignore ... any significant errors should already have been
                    // reported via an IOException from the final flush.
                }
            }
        }
    }
}