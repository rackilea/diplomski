public static byte vls_byteSum(byte[] blk) {
    byte sum = 0;
    for (int i = 0; i < blk.length; i++)
        sum += blk[i];
    return sum;
}