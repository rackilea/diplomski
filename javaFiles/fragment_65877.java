boolean foundMatch = subjectString.matches(
    "(?x)                  # Verbose regex:\n" +
    "(?!.*(AB|CD|EF).*\\1) # Make sure there are no dupes in the string\n" +
    "\\s*                  # Match optional whitespace.\n" +
    "(?:AB|CD|EF)          # Match one of the three candidates\n" +
    "(?:                   # Try to match...\n" +
    " \\s*,\\s*            #  a comma, optionally surrounded by whitespace\n" +
    " (?:AB|CD|EF)         #  followed by one of the candidates\n" +
    ")*                    # zero or more times\n" +
    "\\s*                  # Match optional whitespace.");