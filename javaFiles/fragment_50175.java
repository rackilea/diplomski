public static void main(String[] args) throws IOException {
    final TreeSet<String> strings = new TreeSet<>();
    try (final Reader reader = new InputStreamReader(new FileInputStream(
           System.getProperty("user.home") + "/Downloads/words.txt"), "UTF-8")) {
        final char[] buffer = new char[4];
        int numRead = -1;
        while ((numRead = reader.read(buffer)) > 0) {
            strings.add(new String(buffer, 0, numRead).toUpperCase());
        }
    }
    System.out.println(strings.contains("FLIP"));
    System.out.println(strings.contains("JUMP"));
}