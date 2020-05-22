String[] splitArray = subjectString.split(
    "(?x):    # Multiline regex: Match a colon\n" +
    "(?!      # only if it's impossible to match the following at this point:\n" +
    " [^()]*  #  any number of characters besides parentheses\n" +
    " \\)     #  followed by a closing parenthesis\n" +
    ")        # End of lookahead assertion");