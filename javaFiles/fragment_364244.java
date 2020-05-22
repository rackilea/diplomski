public byte[] getEncoded()
    throws IOException
{
    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    ASN1OutputStream      aOut = new ASN1OutputStream(bOut);

    aOut.writeObject(this); // This is where the throws happens.

    return bOut.toByteArray();
}