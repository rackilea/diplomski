// helper method to read the CSR
public PKCS10CertificationRequest convertPemToPKCS10CertificationRequest(String pem) throws Exception {
    PKCS10CertificationRequest csr = null;
    PEMReader reader = new PEMReader(new StringReader(pem));
    try {
        Object parsedObj = reader.readObject();

        if (parsedObj instanceof PKCS10CertificationRequest) {
            csr = (PKCS10CertificationRequest) parsedObj;
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        reader.close();
    }

    return csr;
}

PKCS10CertificationRequest csr = convertPemToPKCS10CertificationRequest(csrPem);

ASN1Set attributes = csr.getCertificationRequestInfo().getAttributes();
Enumeration<?> objects = attributes.getObjects();
while (objects.hasMoreElements()) {
    Object obj = (Object) objects.nextElement();
    DERSequence seq = (DERSequence) obj;
    DEREncodable objectAt = seq.getObjectAt(0);
    if (objectAt instanceof ASN1ObjectIdentifier) {
        String id = ((ASN1ObjectIdentifier) objectAt).getId();
        if ("1.2.840.113549.1.9.14".equals(id)) { // PKCS#9 ExtensionRequest
            DERSet set = (DERSet) seq.getObjectAt(1);
            // a sequence inside a sequence
            DERSequence reqExt = (DERSequence) ((DERSequence) set.getObjectAt(0)).getObjectAt(0);

            DERObjectIdentifier oid = (DERObjectIdentifier) reqExt.getObjectAt(0);
            ASN1Boolean critical = (ASN1Boolean) reqExt.getObjectAt(1);
            DEROctetString oct = (DEROctetString) reqExt.getObjectAt(2);

            System.out.println(oid.getId()); // 2.5.29.15 - key usage
            System.out.println(critical.isTrue()); // true - is critical

            KeyUsage ku = new KeyUsage(new DERBitString(oct.getOctets()));

            // in my example, the relevant part is in position 3
            // not sure if it's an issue on the way I used openssl to generate the CSR, or if it'll always be at this position
            int bits = ku.getBytes()[3] & 0xff;
            int keyUsageToCheck = KeyUsage.digitalSignature | KeyUsage.keyEncipherment;
            System.out.println((bits & keyUsageToCheck) == keyUsageToCheck); // true - it has the key usages set
        }
    }
}