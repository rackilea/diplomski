public void writeObject(
    ASN1Encodable obj)
    throws IOException
{
    if (obj != null)
    {
        obj.toASN1Primitive().encode(this);
    }
    else
    {
        throw new IOException("null object detected");
    }
}