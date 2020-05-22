public void createSignature(String src, String dest, String fieldname, PrivateKey pk, Certificate[] chain) throws IOException, DocumentException, GeneralSecurityException {

    PdfReader reader = new PdfReader(src);
    FileOutputStream os = new FileOutputStream(dest);
    ExternalSignatureContainer external = new MyExternalSignatureContainer(pk, chain);
    MakeSignature.signDeferred(reader, fieldname, os, external);
}