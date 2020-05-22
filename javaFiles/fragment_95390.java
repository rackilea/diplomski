byte[] array = bigInt.toByteArray();
int len = array.length, len8 = len+7 & ~7;
if(len != len8) {
    int pad = len8 - len;
    byte[] nArray = new byte[len8];
    if(bigInt.signum() < 0) Arrays.fill(nArray, 0, pad, (byte)-1);
    System.arraycopy(array, 0, nArray, pad, len);
    array = nArray;
}