public  static int compareString(String str1, String str2){

    String subString = str1.substring(str1.indexOf("##")+3, str1.length());
    String subString1 = str2.substring(str2.indexOf("##")+3, str2.length());
    String[] array1 = subString.split("-");
    String[] array2 = subString1.split("-");
    for(int i=0;i< array1.length && i< array2.length;i++) {
         BigInteger b1 = new BigInteger(array1[i]);
         BigInteger b2 = new BigInteger(array2[i]);
        if(b1.compareTo(b2) >0) //b1 is larger than b2
            return 1;
        if(b1.compareTo(b2) <0)
            return -1;

    }
    if(array1.length == array2.length)//both numbers are equal
        return 0;

    if(array1.length > array2.length)
        return 1;
    return -1;

}