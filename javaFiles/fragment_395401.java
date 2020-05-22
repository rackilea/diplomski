public static void main(final String... args) {
    // final Pattern pattern = Pattern.compile("(?<=,\\s*)"); won't work!
    final Pattern pattern = Pattern.compile(".+?,\\s*|.+\\s*$");
    final Matcher matcher = 
                  pattern.matcher("I,    am,       the, goddamn, Batman    ");
    while (matcher.find()) {
        System.out.format("\"%s\"\n", matcher.group());
}