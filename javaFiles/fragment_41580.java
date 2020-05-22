public byte[] createArray(int length)
{
    byte[] data = new byte[length]; 
    for (int i=0; i < data.length; i++)
    {
        data[i] = (byte) i;
    }
    return data;
}