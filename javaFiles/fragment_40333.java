public static String verifyInput(String typo) {

    String correctString[] = { "Spades", "Hearts", "Ace", "Club" };

    // A number to store maximum matches
    int maxMatch = 0;

    // Final String
    String finalStr = "";

    // Iterate through array to find best match
    for (String corrStr : correctString) {
        int match = 0;
        String dis = "";

        // Form discrete string
        // We match only discrete characters
        for (char x : typo.toCharArray())
            if (corrStr.toLowerCase().contains(String.valueOf(x).toLowerCase())
                    && !dis.contains(String.valueOf(x))) {
                dis += x;
                match++;
            }

        // Special stuff for ace
        if (corrStr.equals("Ace") && match > corrStr.length() / 2 && typo.length() == 3)
            return corrStr;

        // If the current string had more matches than previous, replace
        // previous with current
        if (match > maxMatch) {
            maxMatch = match;
            finalStr = corrStr;
        }
    }

    return finalStr;
}