int deAdjustId(byte[] s)
{
    int r = 0;
    for (int i = s.length <= 4 ? 0 : s.length - 4; i < s.length; ++i) 
    {
        r = (r << 8) + ((int)s[i] & 255);
    }
    return r;
}

byte[] adjustId(int id)
{
    byte[] ba = new byte[4];
    for (i = 0; i < 4; ++i)
    {
        char c = (char)(id & 255);
        if (c == 0) {
            byte[] ta = new byte[i];
            System.arrayCopy(ba, 4 - i, ta, 0, i);
            ba = ta;
            break;
        }
        ba[3 - i] = (byte)c;
        id = id >>> 8;
    }
    return ba;
}