byte[] array1=new byte[]{0x01,0x05};
    byte[] array2=new byte[]{0x03,0x04,0x02};
    byte[] targetArray = new byte[array1.length + array2.length];
    int cap = array1.length / 2;

    System.arraycopy(array1, 0, targetArray, 0, cap);
    System.arraycopy(array2, 0, targetArray, cap, array2.length);
    System.arraycopy(array1, cap, targetArray, array2.length + cap, array1.length - cap);

    for (byte b : targetArray) {
        System.out.println(b);
    }