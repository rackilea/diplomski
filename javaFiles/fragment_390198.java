public static void main(String[] args) throws Exception {
    final Pattern pattern = Pattern.compile("(?i).*\\babc.*");

    final String[] in = {
        "Abc zcf",
        "Abcd zcf",
        "Zcf Abc",
        "Zcf Abcd",
        "Test ez",
        "Rabc Jabc"};

    for (final String s : in) {
        final Matcher m = pattern.matcher(s);
        if (m.matches()) {
            System.out.println(s);
        }
    }
}