public static void main(String[] args) {
    // Build regexp
    final String MONEY_REGEX = "[$£€]?\\s*\\d*[\\.]?[pP]?\\d*\\d";
    final String RS_REGEX = "Rs[.]?\\s*[\\d,]*[.]?\\d*\\d";

    // Separate them with '|' operator and wrap them in two distinct matching groups
    final String MONEY_OR_RS = String.format("(%s)|(%s)", MONEY_REGEX, RS_REGEX);

    // Prepare some sample inputs
    String[] inputs = new String[] { "$100", "Rs.150", "foo" };

    Pattern p = Pattern.compile(MONEY_OR_RS);

    // Test each inputs
    Matcher m = null;
    for (String input : inputs) {
        if (m == null) {
            m = p.matcher(input);
        } else {
            m.reset(input);
        }

        if (m.matches()) {
            System.out.println(String.format("m.group(0) => %s\nm.group(1) => %s\n", m.group(1), m.group(2)));
        } else {
            System.out.println(input + " doesn't match regexp.");
        }
    }
}