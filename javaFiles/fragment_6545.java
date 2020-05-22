public static void main(String[] args) {
    usingPrint("Hello");
    System.out.println(usingReplaceAll("Hello"));
    System.out.println(usingStringJoiner("Hello"));
    System.out.println(usingStringBuilder("Hello"));
    System.out.println(usingCharArray("Hello"));
}
private static void usingPrint(String input) {
    System.out.print("<-");
    for (int i = 0; i < input.length(); i++)
        System.out.print(input.charAt(i) + "-");
    System.out.println(">");
}
private static String usingReplaceAll(String input) {
    return "<" + input.replaceAll("", "-") + ">";
}
private static String usingStringJoiner(String input) { // Java 8+
    StringJoiner buf = new StringJoiner("-", "<-", "->");
    for (int i = 0; i < input.length(); i++)
        buf.add(input.substring(i, i + 1));
    return buf.toString();
}
private static String usingStringBuilder(String input) {
    StringBuilder buf = new StringBuilder("<");
    for (int i = 0; i < input.length(); i++)
        buf.append('-').append(input.charAt(i));
    return buf.append("->").toString();
}
private static String usingCharArray(String input) {
    char[] buf = new char[input.length() * 2 + 3];
    int j = 0;
    buf[j++] = '<';
    for (int i = 0; i < input.length(); i++) {
        buf[j++] = '-';
        buf[j++] = input.charAt(i);
    }
    buf[j++] = '-';
    buf[j++] = '>';
    return new String(buf);
}