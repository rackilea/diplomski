private static byte[] addPKCS7Padding(byte[] data, int iBlockSize)
{
    int iLength = data.length;
    byte cPadding = (byte)(iBlockSize - (iLength % iBlockSize));
    byte[] output = new byte[iLength + cPadding];
    System.arraycopy(data, 0, output, 0, iLength);
    for (int i = iLength; i < output.length; i++)
        output[i] = (byte)cPadding;
    return output;
}