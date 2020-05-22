public static String deciToBin(int i) {
    String str = "";
    do {
        str = (i & 1) + str;
        i >>>= 1;
    } while (i != 0);
    return str;
}