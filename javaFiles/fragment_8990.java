class MyExternalSignatureContainer implements ExternalSignatureContainer {

    protected PrivateKey pk;
    protected Certificate[] chain;

    public MyExternalSignatureContainer(PrivateKey pk, Certificate[] chain) {
        this.pk = pk;
        this.chain = chain;
    }

    public byte[] sign(InputStream is) throws GeneralSecurityException {
        try {
            PrivateKeySignature signature = new PrivateKeySignature(pk, "SHA256", "BC");
            String hashAlgorithm = signature.getHashAlgorithm();
            BouncyCastleDigest digest = new BouncyCastleDigest();
            PdfPKCS7 sgn = new PdfPKCS7(null, chain, hashAlgorithm, null, digest, false);
            byte hash[] = DigestAlgorithms.digest(is, digest.getMessageDigest(hashAlgorithm));
            Calendar cal = Calendar.getInstance();
            byte[] sh = sgn.getAuthenticatedAttributeBytes(hash, cal, null, null, CryptoStandard.CMS);
            byte[] extSignature = signature.sign(sh);
            sgn.setExternalDigest(extSignature, null, signature.getEncryptionAlgorithm());
            return sgn.getEncodedPKCS7(hash, cal, null, null, null, CryptoStandard.CMS);
        }
        catch (IOException ioe) {
            throw new ExceptionConverter(ioe);
        }
    }

    public void modifySigningDictionary(PdfDictionary signDic) {
    }

}