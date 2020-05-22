private static String resolveTimestamp(String s) {
    String timestamp = "\\{TIMESTAMP}";

    while(s.matches(timestamp)) {
       s = s.replaceFirst(timestamp, String.valueOf(System.nanoTime()));
    }
    return s;
}