private static final void byteToShort(final byte[] bytes, final short blen, final short[] shorts)
{
    short x = 0;
    short y = 0;
    for (; y < blen; x++, y += 2)
    {
        shorts[x] = Util.getShort(bytes, y);
    }
}