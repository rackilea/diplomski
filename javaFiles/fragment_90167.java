public static byte[] intToByteArray(int a)
{
    return new byte[] {
        (byte) ((a >> 24) & 0xFF),
        (byte) ((a >> 16) & 0xFF),   
        (byte) ((a >>  8) & 0xFF),   
        (byte) ((a      ) & 0xFF),
    };
}

public long bytesToLong(byte[] by)
{
    long value = 0;
    for (int i = 0; i < by.length; i++)
    {
        value |= ( by[i] & 0xFF ) << ( i * 8 );
    }
    return value;
}