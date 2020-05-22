private static final String SIGNATURE_ALGO = "SHA256WithRSA";

/**
 * Get the pkcs7-signature from a document hash (sha256Hex)
 *
 * @param contentSha256Hex
 *     the original document content hash (sha256Hex) to be signed
 * @return the pkcs7 signature
 *
 * note: see TestSha1WithRsaAndAttributeTable() in bouncycastle/test/src/cms/test/SignedDataTest.cs
 * */
public byte[] signSha256Hex(final String contentSha256Hex)
    throws CertificateEncodingException, IOException, OperatorCreationException, CMSException, DecoderException {

    byte[] hash = Hex.decodeHex(contentSha256Hex);

    /*
     * The trick is to manually set digest attribute with hash value,
     * then generate signature without content.
     */

    // CMS attributes
    ASN1EncodableVector v = new ASN1EncodableVector();
    v.add(new Attribute(CMSAttributes.messageDigest, new DERSet(new DEROctetString(hash)))); // set digest (sha256)

    return signCms_Sha256WithRsa(
        new CMSAbsentContent(),
        new DefaultSignedAttributeTableGenerator(new AttributeTable(v)));

}

private byte[] signCms_Sha256WithRsa(CMSTypedData content, CMSAttributeTableGenerator signedAttributes)
    throws CMSException, IOException, CertificateEncodingException, OperatorCreationException {

    CMSSignedDataGenerator generator = new CMSSignedDataGenerator();

    // content signer
    ContentSigner signer = new JcaContentSignerBuilder(SIGNATURE_ALGO).setProvider("BC").build(privateKey);
    generator.addSignerInfoGenerator(
        new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().setProvider("BC").build())
            .setSignedAttributeGenerator(signedAttributes)
            .build(signer, certificate));

    // add certificate
    generator.addCertificate(new X509CertificateHolder(certificate.getEncoded()));

    // sign
    CMSSignedData cmsSignedData = generator.generate(content, false);
    return cmsSignedData.getEncoded();
}