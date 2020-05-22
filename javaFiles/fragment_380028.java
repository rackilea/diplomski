private static final Random r = new Random( System.currentTimeMillis() );

public String getWord( final Integer length ) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
        final int rnd = r.nextInt( 52 );
        final char c = (char) (rnd < 26 ? 'a' + rnd : 'A' + (rnd-26));
        sb.append( c );
    }
    return sb.toString();
}