//intArray contains your data...
    byte[] utf8bytes = new byte[intArray.length];
    for(int i = 0; i < intArray.length; i++)
    {
        utf8bytes[i] = (byte) intArray[i];
    }