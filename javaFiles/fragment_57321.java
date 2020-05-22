public TextFragments<E> getTextFragments( TokenStream tokenStream,
        String text,
        Scorer scorer )
        throws IOException, InvalidTokenOffsetsException {
    OffsetAttribute offsetAtt = (OffsetAttribute) tokenStream.addAttribute( OffsetAttribute.class );
    TermAttribute termAtt = (TermAttribute) tokenStream.addAttribute( TermAttribute.class );
    TokenStream newStream = scorer.init( tokenStream );
    if ( newStream != null ) {
        tokenStream = newStream;
    }

    TokenGroups tgs = new TokenGroups();
    scorer.startFragment( null );
    while ( tokenStream.incrementToken() ) {
        tgs.add( offsetAtt.startOffset(), offsetAtt.endOffset(), scorer.getTokenScore() );
        if ( log.isTraceEnabled() ) {
            log.trace( new StringBuilder()
                    .append( scorer.getTokenScore() )
                    .append( " " )
                    .append( offsetAtt.startOffset() )
                    .append( "-" )
                    .append( offsetAtt.endOffset() )
                    .append( ": '" )
                    .append( termAtt.term() )
                    .append( "', '" )
                    .append( text.substring( offsetAtt.startOffset(), offsetAtt.endOffset() ) )
                    .append( "'" )
                    .toString() );
        }
    }

    return tgs.fragment( text );
}

private class TokenGroup {
    private int startIndex;
    private int endIndex;
    private float score;

    public TokenGroup( int startIndex, int endIndex, float score ) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.score = score;
    }
}

private class TokenGroups implements Iterable<TokenGroup> {
    private List<TokenGroup> tgs;

    public TokenGroups() {
        tgs = new ArrayList<TokenGroup>();
    }

    public void add( int startIndex, int endIndex, float score ) {
        add( new TokenGroup( startIndex, endIndex, score ) );
    }

    public void add( TokenGroup tg ) {
        for ( int i = tgs.size() - 1; i >= 0; i-- ) {
            if ( tg.startIndex < tgs.get( i ).endIndex ) {
                tg = merge( tg, tgs.remove( i ) );
            }
            else {
                break;
            }
        }
        tgs.add( tg );
    }

    private TokenGroup merge( TokenGroup tg1, TokenGroup tg2 ) {
        return new TokenGroup( Math.min( tg1.startIndex, tg2.startIndex ),
                Math.max( tg1.endIndex, tg2.endIndex ),
                Math.max( tg1.score, tg2.score ) );
    }

    private TextFragments<E> fragment( String text ) {
        TextFragments<E> fragments = new TextFragments<E>();

        int lastEndIndex = 0;
        for ( TokenGroup tg : this ) {
            if ( tg.startIndex > lastEndIndex ) {
                fragments.add( text.substring( lastEndIndex, tg.startIndex ), textModeNormal );
            }
            fragments.add( 
                    text.substring( tg.startIndex, tg.endIndex ),
                    tg.score > 0 ? textModeHighlighted : textModeNormal );
            lastEndIndex = tg.endIndex;
        }

        if ( lastEndIndex < ( text.length() - 1 ) ) {
            fragments.add( text.substring( lastEndIndex ), textModeNormal );
        }

        return fragments;
    }

    @Override
    public Iterator<TokenGroup> iterator() {
        return tgs.iterator();
    }
}