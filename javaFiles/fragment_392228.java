private static final CharMatcher CHAR_MATCHER_ASCII = 
    CharMatcher.inRange('0', '9')
        .or(CharMatcher.inRange('a', 'z'))
        .or(CharMatcher.inRange('A', 'Z'))
        .or(CharMatcher.anyOf(" _.-")) // note space here
        .precomputed();