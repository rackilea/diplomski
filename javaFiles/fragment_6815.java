private enum Choice {

    ROCK ("Rock"),
    PAPER ("Paper"),
    SCISSORS ("Scissors");

    private String displayName;

    private static final List<Choice> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
          private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();        

    private Choice(String dn) {
        displayName = dn;
    }

    /**
     * Returns a random Choice.
     */
    public static Choice getRandomChoice() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    /**
     * Returns a Choice that matches the input string. The input is considered a match if it starts with the same character 
     * as the displayname of a Choice. If no match is found, returns null.
     */
    public static Choice fromInput(String input) {

        if (input == null || input.length() == 0) {
            return null;
        }

        for (Choice c : VALUES) {
            if (Character.toLowerCase(c.displayName.charAt(0))
                    == Character.toLowerCase(input.charAt(0))) {
                return c;
            }
        }
        return null;
    }

    /**
     * Returns the text to display to the user, asking for input to #fromInput().
     */
    public static String promptText() {
        StringBuilder sb = new StringBuilder();
        for (Choice c : VALUES) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(c.displayName).append(" (")
                    .append(c.displayName.charAt(0)).append(")");
        }
        sb.append(". Pick one!");
        return sb.toString();
    }
}