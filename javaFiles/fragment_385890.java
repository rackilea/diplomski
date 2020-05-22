public static long binaryToInteger(String binaryString) {
    char[] chars = binaryString.toCharArray();
    long resultInt = 0;
    int placeHolder = 0;
    for (int i=chars.length-1; i>=0; i--) {
        if (chars[i]=='1') {
          resultInt += Math.pow(2,placeHolder);
        }
        placeHolder++;
    }
    return resultInt;
}