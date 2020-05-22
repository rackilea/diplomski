Pattern pattern = Pattern.compile(
    "\\b" 
    + Pattern.quote(highlight)
    + "(?![^\\p{Punct}\\s])", // matches if the match is not followed by
                              // anything other than whitespace or punctuation
    Pattern.CASE_INSENSITIVE);