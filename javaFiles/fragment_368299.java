static String reverse(String stringIn) {
    char[] cArr = stringIn.toCharArray();
    for (int i = 0; i < cArr.length/2; ++i){
        char c = cArr[i];
        cArr[i] = cArr[cArr.length-1-i];
        cArr[cArr.length-1-i] = c;
    }
    return new String(cArr);
}