String input = "CREATE FUNCTION ...\n" +
        "...\n" +
        "...\n" +
        "BEGIN\n" +
        "\n" +
        "  DECLARE ...\n" +
        "  DECLARE ...\n" +
        "...\n" +
        "END";
Matcher m = Pattern.compile("(?:\\s+DECLARE.+)+").matcher(input);
if (m.find()) {
    String firstPart = input.substring(0, m.start());
    String secondPart = m.group();
    String thirdPart = input.substring(m.end());
    System.out.println(thirdPart);
}