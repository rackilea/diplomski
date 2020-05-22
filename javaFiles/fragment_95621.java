private static void print(String msg, Object... args) {
    try {
        PrintStream ps = new PrintStream(System.out, true, "UTF-8");
        ps.println(String.format(msg, args));
    } catch (UnsupportedEncodingException error) {
        System.err.println(error);
        System.exit(0);
    }
}

public static void main (String[] args) throws UnsupportedEncodingException {
    String arabicString = "كيف حالك";
    print(arabicString);
}