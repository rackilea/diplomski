result = s.replaceAll(
    "(?x)     # Allow comments in the regex.                     \n" +
    "\\(      # Either match a (                                 \n" +
    "[^()]*   # then any number of characters except parentheses \n" +
    "\\)      # then a ).                                        \n" +
    "|        # Or                                               \n" +
    "[*+\\ ]+ # Match one or more asterisks, pluses or spaces", "");