private static final Set<String> s = new HashSet<String>();

static {
    s.add( "f**k" );
    s.add( "suck" );
    s.add( "dick" );
}

private static final Random r = new Random( System.currentTimeMillis() );

public String getWord( Integer length ) {
    String cand = getRandomWord( length );
    while ( isSwearWord(cand) ) {
        cand = getRandomWord( length );
    }
    return cand;
}

private boolean isSwearWord( final String w ) {
    return s.contains( w.toLowerCase() );
}

public String getRandomWord( final Integer length ) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
        final int rnd = r.nextInt( 52 );
        final char c = (char) (rnd < 26 ? 'a' + rnd : 'A' + (rnd-26));
        sb.append( c );
    }
    return sb.toString();
}