byte[] array1=new byte[]{0x01,0x05};
    byte[] array2=new byte[]{0x03,0x04,0x02};
    byte[] targetArray = new byte[array1.length + array2.length];

    System.arraycopy(array1, 0, targetArray, 0, array1.length);
    System.arraycopy(array2, 0, targetArray, array1.length, array2.length);

    for (byte b : targetArray) {
        System.out.println(b);
    }