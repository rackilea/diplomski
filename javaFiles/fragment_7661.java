private byte[] makeDEREncodedRequest(final PKCS10CertificationRequest request) {
    try {
        return request.toASN1Structure().getEncoded(ASN1Encoding.DER);
    } catch (IOException e) {
        // ... <Exception handling code> ...
    }
}