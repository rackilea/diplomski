public static String deciToBin(int i) {
    StringBuilder str = new StringBuilder();
    do {
        str.append(i & 1);
        i >>>= 1;
    } while (i != 0);
    return str.reverse().toString();
}