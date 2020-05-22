//helper functions
public static final byte[] getByteArrayFromIndex(byte[] data, int index){
       return new byte[] {
        data[index],
        data[index+1],
        data[index+2],
        data[index+3]
       };
}

public static final byte getByteFromIndex(byte[] data, int index){
       return data[index];
}

public static long getLongFromByteArray(byte[] array){
    return ByteBuffer.wrap(array)
               .order(ByteOrder.LITTLE_ENDIAN).getInt() & 0xFFFFFFFFL;

}

  private static byte[] convertLongToByteArray(long l) {
      byte[] b = new byte[4];
      if(java.nio.ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN){
      for (int i=0; i<4; i++) {
        b[i] = (byte)(l % 256) ;
        l = l / 256;
      }
     }else{
      for (int i=3; i>=0; i--) {
        b[i] = (byte)(l % 256) ;
        l = l / 256;
      }
     }
      return b;
  }

//Crc32FourBytes
private static long Crc32FourBytes(byte[] data, long length, long previousCrc32, boolean is_bigendian)
{    //long crc = ~previousCrc32; // same as previousCrc32 ^ 0xFFFFFFFF
    //force long to unsigned integer below
    long crc = Complement(previousCrc32);
    int i = 0;
    int j = data.length;
    long temp = 0;
    for( ; j >= 4 ; j = j-4){
    if (is_bigendian == true){
        temp = getLongFromByteArray(getByteArrayFromIndex(data,i));
        long one = temp ^ swap(crc);
        System.out.format("one is %d\n", LongToInt(one));
        crc  = Crc32Lookup[0][LongToInt((one) & 0xFF)] ^
               Crc32Lookup[1][LongToInt((one>>>8) & 0xFF)] ^
               Crc32Lookup[2][LongToInt((one>>>16) & 0xFF)] ^
               Crc32Lookup[3][LongToInt((one>>>24) & 0xFF)];
        System.out.format("crc is %d\n", LongToInt(crc));
    } else {
        temp = getLongFromByteArray(getByteArrayFromIndex(data,i));
        long one = temp ^ (crc);
        crc  = Crc32Lookup[0][LongToInt((one>>>24) & 0xFF)] ^
               Crc32Lookup[1][LongToInt((one>>>16) & 0xFF)] ^
               Crc32Lookup[2][LongToInt((one>>>8 ) & 0xFF)] ^
               Crc32Lookup[3][LongToInt((one     ) & 0xFF)];
        System.out.format("crc is %d\n", LongToInt(crc));
    }
    i += 4;
    //System.out.format("%d\n",k);
    }
    // Remaining 1 to 3 bytes (standard algorithm)
    for (int k=data.length-i; k >0; k--)
    {
    crc = (LongToInt(crc) >>> 8) ^ Crc32Lookup[0][LongToInt((LongToInt(crc) & 0xFF) ^ LongToInt(data[data.length-k]))];
    System.out.format("=> crc is %d\n", LongToInt(crc));
    }
    return Complement(crc); //return crc ^ 0xFFFFFFFF;
}