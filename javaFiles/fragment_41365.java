public static String upperCaseRandom(String input, int n) {
    final int length = input.length();
    final StringBuilder output = new StringBuilder(input);
    final boolean[] alreadyChecked = new boolean[length];
    final Random r = new Random();

    for (int i = 0, checks = 0; i < n && checks < length; i++) {
        // Pick a place
        int position = r.nextInt(length);

        // Check if lowercase alpha
        if (!alreadyChecked[position]) {
            if (Character.isLowerCase(output.charAt(position))) {
                output.setCharAt(position, Character.toUpperCase(output.charAt(position)));
            } else {
                i--;
            }
            checks++;
            alreadyChecked[position] = true;
        } else {
            i--;
        }
    }
    return output.toString();
}