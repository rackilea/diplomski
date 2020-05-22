public final int readUnsignedShort()
    throws IOException
{
    int ch1 = m_byteArray[m_nCounter++];
    int ch2 = m_byteArray[m_nCounter++];

    if ( ch1 < 0 )
    {
        ch1 = ch1 + 256;
    }
    if ( ch2 < 0 )
    {
        ch2 = ch2 + 256;
    }
    return ((ch2 << 8) & 0xFF00) + (ch1 & 0x00FF);
}