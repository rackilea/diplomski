public static double getFloat64(byte[] bytes)
    {
        return Double.longBitsToDouble(((bytes[0] & 0xFFL) << 56) 
            | ((bytes[1] & 0xFFL) << 48) 
            | ((bytes[2] & 0xFFL) << 40) 
            | ((bytes[3] & 0xFFL) << 32)
            | ((bytes[4] & 0xFFL) << 24) 
            | ((bytes[5] & 0xFFL) << 16) 
            | ((bytes[6] & 0xFFL) << 8) 
            | ((bytes[7] & 0xFFL) << 0)); 
    }