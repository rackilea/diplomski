public static float byteArrayToFloat(byte[] p_bArray)
{
    int nValue;

    nValue = (0xFF & p_bArray[0]);
    nValue = nValue | ((0xFF & p_bArray[1]) << 8);
    nValue = nValue | ((0xFF & p_bArray[2]) << 16);
    nValue = nValue | ((0xFF & p_bArray[3]) << 24);

    float fValue = Float.intBitsToFloat(nValue);

    return fValue;
}

public static byte[] floatToByteArray(float p_fValue)
{
    byte [] bArray = new byte[4];
    int nValue;

    nValue = Float.floatToIntBits(p_fValue);

    bArray[0] = (byte)nValue;
    bArray[1] = (byte)(nValue >> 8);
    bArray[2] = (byte)(nValue >> 16);
    bArray[3] = (byte)(nValue >> 24);

    return bArray;
}

public static double byteArrayToDouble(byte[] p_bArray)
{
    long lValue;

    lValue = (long)p_bArray[0] & 0xFF;
    lValue = lValue | (((long)p_bArray[1] & 0xFF) << 8);
    lValue = lValue | (((long)p_bArray[2] & 0xFF) << 16);
    lValue = lValue | (((long)p_bArray[3] & 0xFF) << 24);
    lValue = lValue | (((long)p_bArray[4] & 0xFF) << 32);
    lValue = lValue | (((long)p_bArray[5] & 0xFF) << 40);
    lValue = lValue | (((long)p_bArray[6] & 0xFF) << 48);
    lValue = lValue | (((long)p_bArray[7] & 0xFF) << 56);

    double dValue = Double.longBitsToDouble(lValue);

    return dValue;
}

public static byte[] doubleToByteArray(double p_dValue)
{
    byte [] bArray = new byte[8];
    long lValue;

    lValue = Double.doubleToLongBits(p_dValue);

    bArray[0] = (byte)lValue;
    bArray[1] = (byte)(lValue >> 8);
    bArray[2] = (byte)(lValue >> 16);
    bArray[3] = (byte)(lValue >> 24);
    bArray[4] = (byte)(lValue >> 32);
    bArray[5] = (byte)(lValue >> 40);
    bArray[6] = (byte)(lValue >> 48);
    bArray[7] = (byte)(lValue >> 56);

    return bArray;
}

public static int byteArrayToInt(byte[] p_bArray)
{
    int nValue;

    nValue = ((int)p_bArray[0]) & 0x000000FF;
    nValue = nValue | (((int)p_bArray[1] & 0x000000FF) << 8);
    nValue = nValue | (((int)p_bArray[2] & 0x000000FF) << 16);
    nValue = nValue | (((int)p_bArray[3] & 0x000000FF) << 24);

    return nValue;
}

public static byte[] intToByteArray(int p_nValue)
{
    byte [] bArray = new byte[4];

    bArray[0] = (byte)p_nValue;
    bArray[1] = (byte)(p_nValue >> 8);
    bArray[2] = (byte)(p_nValue >> 16);
    bArray[3] = (byte)(p_nValue >> 24);

    return bArray;
}