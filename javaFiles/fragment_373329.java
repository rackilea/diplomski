Static public DERObject toDERObject(byte[] data) throws IOException
{
    ByteArrayInputStream inStream = new ByteArrayInputStream(data);
    ASN1InputStream DIS = new ASN1InputStream(inStream);
    return DIS.readObject();
}