public int findFirstOf( String sequence, String str ) {
    return CharMatcher.anyOf( str ).indexIn( sequence );
}

public int findFirstNotOf( String sequence, String str ) {
    return CharMatcher.anyOf( str ).negate().indexIn( sequence );
}

public int findLastOf( String sequence, String str ) {
    return CharMatcher.anyOf( str ).lastIndexIn( sequence );
}

public int findLastNotOf( String sequence, String str ) {
    return CharMatcher.anyOf( str ).negate().lastIndexIn( sequence );
}