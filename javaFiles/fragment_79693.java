Pattern regex = Pattern.compile(
    "(\\d+)        # File size           \n" +
    "\\s+          # Whitespace          \n" +
    "\\w{3}        # Month (3 letters)   \n" +
    "\\s+          # Whitespace          \n" +
    "\\d{1,2}      # Day (1 or 2 digits) \n" +
    "\\s+          # Whitespace          \n" +
    "[\\d:]{4,5}   # Time or year        \n" +
    "\\s+          # Whitespace          \n" +
    "(.*)          # Filename            \n" +
    "$             # End of line", 
    Pattern.MULTILINE | Pattern.COMMENTS);