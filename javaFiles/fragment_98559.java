private static long Crc32EightBytes(byte[] data, long length, long previousCrc32, boolean is_bigendian)
{    //long crc = ~previousCrc32; // same as previousCrc32 ^ 0xFFFFFFFF
    //force long to unsigned integer below
    long crc = Complement(previousCrc32);
    int i = 0;
    int j = data.length;
    long temp = 0;
    for( ; j >= 8 ; j = j-8){
    if (is_bigendian == true){
        //First set of four
        temp = getLongFromByteArray(getByteArrayFromIndex(data,i));
        long one = temp ^ swap(crc);
        //Second set of four
        i += 4;
        temp = getLongFromByteArray(getByteArrayFromIndex(data,i));
        long two = temp;
        System.out.format("one is %d\n", LongToInt(one));
        System.out.format("two is %d\n", LongToInt(one));
        crc  = Crc32Lookup[0][LongToInt((two    )  & 0xFF)] ^
               Crc32Lookup[1][LongToInt((two>>>8)  & 0xFF)] ^
               Crc32Lookup[2][LongToInt((two>>>16) & 0xFF)] ^
               Crc32Lookup[3][LongToInt((two>>>24) & 0xFF)] ^
               Crc32Lookup[4][LongToInt((one     ) & 0xFF)] ^
               Crc32Lookup[5][LongToInt((one>>>8)  & 0xFF)] ^
               Crc32Lookup[6][LongToInt((one>>>16) & 0xFF)] ^
               Crc32Lookup[7][LongToInt((one>>>24) & 0xFF)];
        System.out.format("crc is %d\n", LongToInt(crc));
    } else {
        //First set of four
        temp = getLongFromByteArray(getByteArrayFromIndex(data,i));
        long one = temp ^ (crc);
        //Second set of four
        i += 4;
        temp = getLongFromByteArray(getByteArrayFromIndex(data,i));
        long two = temp;
        crc  = Crc32Lookup[0][LongToInt((two>>>24) & 0xFF)] ^
               Crc32Lookup[1][LongToInt((two>>>16) & 0xFF)] ^
               Crc32Lookup[2][LongToInt((two>>>8 ) & 0xFF)] ^
               Crc32Lookup[3][LongToInt((two     ) & 0xFF)] ^
               Crc32Lookup[4][LongToInt((one>>>24) & 0xFF)] ^
               Crc32Lookup[5][LongToInt((one>>>16) & 0xFF)] ^
               Crc32Lookup[6][LongToInt((one>>>8 ) & 0xFF)] ^
               Crc32Lookup[7][LongToInt((one     ) & 0xFF)];
        System.out.format("crc is %d\n", LongToInt(crc));
    }
    //Increment by 4 here because we increment by another 4 for second set in the iterative loop making total increment by 4+4 = 8
    i += 4;
    System.out.format("%d\n",i);
    }
    // Remaining 1 to 7 bytes (standard algorithm)
    for (int k=data.length-i; k >0; k--)
    {
    crc = (LongToInt(crc) >>> 8) ^ Crc32Lookup[0][LongToInt((LongToInt(crc) & 0xFF) ^ LongToInt(data[data.length-k]))];
    System.out.format("=>>>> crc is %d\n", LongToInt(crc));
    }
    return Complement(crc); //return crc ^ 0xFFFFFFFF;
}