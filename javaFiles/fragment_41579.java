public void createArray(byte[] data, int length)
{
    // Eek! Change to parameter won't get seen by caller
    data = new byte[length]; 
    for (int i=0; i < data.length; i++)
    {
        data[i] = (byte) i;
    }
}