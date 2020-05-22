public static byte [] long2ByteArray (long value)
{
    return ByteBuffer.allocate(8).putLong(value).array();
}

public static byte [] float2ByteArray (float value)
{  
     return ByteBuffer.allocate(4).putFloat(value).array();
}