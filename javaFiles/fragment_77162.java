public class SignedDataTest {
  ... see Part 1

    private static void verify(Path signedFile, Path extractToFile) throws Exception {
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
        JcaSimpleSignerInfoVerifierBuilder verifier = new JcaSimpleSignerInfoVerifierBuilder().setProvider("BC");

        for (Object objSigner : sp.getSignerInfos().getSigners()) {
            SignerInformation signer = (SignerInformation) objSigner;
            // as I understand it, there should be only one match ....but anyways....
            for (Object objMatch : certStore.getMatches(signer.getSID())) {
                X509CertificateHolder certHolder = (X509CertificateHolder) objMatch;
                System.out.print("verifying against " + certHolder.getSubject().toString());
                if (signer.verify(verifier.build(certHolder))) {
                    System.out.println(": verified");
                } else {
                    System.out.println(": no match");
                }
            }
        }
    }
}