private static String encriptar(String xmlSolicitud, PrivateKey privateKey)
        throws Exception {

    Signature signature=Signature.getInstance("SHA1withRSA");
    signature.initSign(privateKey);
    signature.update(xmlSolicitud.getBytes(Charset.forName("UTF-8")));

    byte[] signatureValue = signature.sign();
    String response = Base64.encode(signatureValue);

    signature.initVerify(keyReader.publicKeyRead(Reference.rutaPublicKeyTest));
    signature.update(xmlSolicitud.getBytes(Charset.forName("UTF-8"))); // <-- Here

    System.out.println(signature.verify(signatureValue)); // <-- Will print true

    return response;
}