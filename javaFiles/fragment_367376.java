private static byte[] MakeTagLengthValue(byte tag, byte[] value, int index = 0, int length = -1)
{
    if (length == -1)
    {
        length = value.Length - index;
    }

    byte[] data;

    if (length < 0x80)
    {
        data = new byte[length + 2];
        data[1] = (byte)length;
    }
    else if (length <= 0xFF)
    {
        data = new byte[length + 3];
        data[1] = 0x81;
        data[2] = (byte)length;
    }
    else if (length <= 0xFFFF)
    {
        data = new byte[length + 4];
        data[1] = 0x82;
        data[2] = (byte)(length >> 8);
        data[3] = unchecked((byte)length);
    }
    else
    {
        throw new InvalidOperationException("Continue the pattern");
    }

    data[0] = tag;
    int dataOffset = data.Length - length;
    Buffer.BlockCopy(value, index, data, dataOffset, length);
    return data;
}

private static byte[] MakeInteger(byte[] unsignedBigEndianValue)
{
    if (unsignedBigEndianValue[0] >= 0x80)
    {
        byte[] tmp = new byte[unsignedBigEndianValue.Length + 1];
        Buffer.BlockCopy(unsignedBigEndianValue, 0, tmp, 1, unsignedBigEndianValue.Length);
        return MakeTagLengthValue(0x02, tmp);
    }

    for (int i = 0; i < unsignedBigEndianValue.Length; i++)
    {
        if (unsignedBigEndianValue[i] != 0)
        {
            if (unsignedBigEndianValue[i] >= 0x80)
            {
                i--;
            }

            return MakeTagLengthValue(0x02, unsignedBigEndianValue, i);
        }
    }

    // All bytes were 0, encode 0.
    return MakeTagLengthValue(0x02, unsignedBigEndianValue, 0, 1);
}

private static byte[] MakeSequence(params byte[][] data)
{
    return MakeTagLengthValue(0x30, data.SelectMany(a => a).ToArray());
}

private static byte[] MakeBitString(byte[] data)
{
    byte[] tmp = new byte[data.Length + 1];
    // Insert a 0x00 byte for the unused bit count value
    Buffer.BlockCopy(data, 0, tmp, 1, data.Length);
    return MakeTagLengthValue(0x03, tmp);
}

private static byte[] s_rsaAlgorithmId = new byte[] { 0x30, 0x0D, 0x06, 0x09, 0x2A, 0x86, 0x48, 0x86, 0xF7, 0x0D, 0x01, 0x01, 0x01, 0x05, 0x00 };

private static byte[] ExportSubjectPublicKeyInfo(RSA rsa)
{
    RSAParameters parameters = rsa.ExportParameters(false);

    return MakeSequence(
        s_rsaAlgorithmId,
        MakeBitString(
            MakeSequence(
                MakeInteger(parameters.Modulus),
                MakeInteger(parameters.Exponent))));
}