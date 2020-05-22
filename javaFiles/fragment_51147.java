public static String byteFormat(String src) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < src.length(); i++) {

        char chr = src.charAt(i);
        String format= String.format("%8s", Integer.toBinaryString(chr)).replace(' ', '0');
        sb.append(format);
    }
    return sb.toString();

}