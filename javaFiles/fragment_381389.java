static byte[] lower4bytes(long v)
{
    return new byte[] {
            (byte)(v    ),
            (byte)(v>> 8),
            (byte)(v>>16),
            (byte)(v>>24)
    };
}