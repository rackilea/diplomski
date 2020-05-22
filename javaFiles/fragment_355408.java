public static String quote(String text) {
    if (text.contains("\"")
        return '"' + text.replaceAll("\"", "\"\"") + '"';
    if (text.contains(",") || text.contains("'"))
       return '"' + text + '"';
    return text;
}