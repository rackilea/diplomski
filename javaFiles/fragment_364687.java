private static byte computeLuminance(byte r, byte g, byte b)
{
    int ir = r & 0xFF;
    int ig = g & 0xFF;
    int ib = b & 0xFF;
    return (byte)(ir * 0.299 + ig * 0.587 + ib * 0.114);
}