public void emptySignature(String src, String dest, String fieldname, Certificate[] chain) throws IOException, DocumentException, GeneralSecurityException {
    PdfReader reader = new PdfReader(src);
    FileOutputStream os = new FileOutputStream(dest);
    PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0');
    PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
    appearance.setVisibleSignature(new Rectangle(36, 748, 144, 780), 1, fieldname);
    appearance.setCertificate(chain[0]);
    ExternalSignatureContainer external = new ExternalBlankSignatureContainer(PdfName.ADOBE_PPKLITE, PdfName.ADBE_PKCS7_DETACHED);
    MakeSignature.signExternalContainer(appearance, external, 8192);
}