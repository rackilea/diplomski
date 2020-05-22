public static void main( String[] args ) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String s = reader.readLine();

    int pos = 0;
    boolean capitalize = true;
    StringBuilder sb = new StringBuilder(s);
    while (pos < sb.length()) {
        if (sb.charAt(pos) == ' ') {
            capitalize = true;
        } else if (capitalize && !Character.isWhitespace(sb.charAt(pos))) {
            sb.setCharAt(pos, Character.toUpperCase(sb.charAt(pos)));
            capitalize = false;
        }
        pos++;
    }
    System.out.println(sb.toString());
}