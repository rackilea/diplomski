Pattern regex = Pattern.compile(
    ",         # Match a comma\n" +
    "(?!       # only if it's not followed by...\n" +
    " [^(]*    #   any number of characters except opening parens\n" +
    " \\)      #   followed by a closing parens\n" +
    ")         # End of lookahead", 
    Pattern.COMMENTS);