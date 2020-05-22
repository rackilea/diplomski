public class SignedDataTest {

    private static final File KEYSTORE_FILE = new File("c:\\temp\\Software_View_Certificate_Authority.p12");
    private static final String KEYSTORE_TYPE = "pkcs12";
    private static final char[] KEYSTORE_PWD = "foobar".toCharArray();
    private static final String KEYSTORE_ALIAS = "Software View Certificate Authority";

    private static final Path CONTENT_SRC_PATH = Paths.get("c:\\temp\\test.txt");
    private static final Path CONTENT_TARGET_PATH = Paths.get("c:\\temp\\test-retrieved.txt");
    private static final Path SIGNEDDATA_TARGET_PATH = Paths.get("c:\\temp\\test.txt.signed.pkcs7");

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        doForth();
        andBack();
    }

    private static void doForth() throws Exception {
        KeyStore ks = KeyStore.getInstance(KEYSTORE_TYPE, "BC");
        ks.load(new FileInputStream(KEYSTORE_FILE), KEYSTORE_PWD);
        X500PrivateCredential creds = new X500PrivateCredential(
                (X509Certificate) ks.getCertificate(KEYSTORE_ALIAS),
                (PrivateKey) ks.getKey(KEYSTORE_ALIAS, KEYSTORE_PWD)
        );
        createSignature(CONTENT_SRC_PATH, creds, new FileOutputStream(SIGNEDDATA_TARGET_PATH.toFile()));
    }

    private static void andBack() throws Exception {
        KeyStore msCertStore = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
        msCertStore.load(null, null);
        SignerInformationVerifier verifier = new JcaSimpleSignerInfoVerifierBuilder().setProvider("SunMSCAPI")
                .build(((X509Certificate) msCertStore.getCertificate("Software View Certificate Authority")));
        verify(SIGNEDDATA_TARGET_PATH, CONTENT_TARGET_PATH, verifier);
    }

    private static void verify(Path signedFile, Path extractToFile, SignerInformationVerifier verifier) throws Exception {
        FileInputStream fis = new FileInputStream(signedFile.toFile());

        DigestCalculatorProvider build = new JcaDigestCalculatorProviderBuilder().setProvider("BC").build();
        CMSSignedDataParser sp = new CMSSignedDataParser(build, fis);

        // we have to read the whole stream sp.getSignedContent().getContentStream()
        // just copy it to the target file
        Files.copy(sp.getSignedContent().getContentStream(), extractToFile, StandardCopyOption.REPLACE_EXISTING);
        // now we can go on with the other stuff.....

        Store certStore = sp.getCertificates();
        // the examples create a new instance of this for each certificate. 
        // I don't think that's necessary, but you might want to look into that...

        for (Object objSigner : sp.getSignerInfos().getSigners()) {
            SignerInformation signer = (SignerInformation) objSigner;
            if (signer.verify(verifier)) {
                System.out.println("verified");
                // now(!) you want to keep the target content file
            } else {
                // actually a "org.bouncycastle.cms.CMSSignerDigestMismatchException: message-digest attribute value does not match calculated value"
                // exception will be thrown in case the contents has been altered
                // So, you will need a try-catch(-finally?) construct to delete the target contents file in such cases....
                System.out.println("no match");
            }
        }
    }

    private static void createSignature(Path srcfile, X500PrivateCredential creds, FileOutputStream target) throws Exception {
        CMSSignedDataStreamGenerator gen = new CMSSignedDataStreamGenerator() {
            {
                addSignerInfoGenerator(
                        new JcaSignerInfoGeneratorBuilder(
                                new JcaDigestCalculatorProviderBuilder().setProvider("BC").build()
                        ).build(
                                new JcaContentSignerBuilder("SHA1withRSA").setProvider("BC").build(creds.getPrivateKey()),
                                creds.getCertificate()
                        )
                );
                addCertificates(new JcaCertStore(new ArrayList<X509Certificate>() {
                    {
                        add(creds.getCertificate());
                    }
                }));
            }
        };
        try (OutputStream sigOut = gen.open(target, true)) {
            Files.copy(srcfile, sigOut);
        }
    }
}