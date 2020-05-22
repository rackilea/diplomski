public static String readLine() throws IOException {
    StringBuilder sb = new StringBuilder();
    for (int ch; (ch = System.in.read()) > 0;)
        if (ch == '\r') continue;
        else if (ch == '\n') break;
        else sb.append(ch);
    return sb.toString();
}