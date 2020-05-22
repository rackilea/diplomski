public int handScore( List<Card> cards ) {
    int handScore = 0;
    // This assumes cards come in sorted with Ace last
    for( Card card : cards ) {
        int cardValue = ( card == ACE ) ? aceValue( handScore ) ? card.getValue();
        handScore += cardValue;
    }
    return handScore;
}

private int aceValue( int handScore ) {
    return ( handScore + 11 <= 21 ) ? 11 : 1;
}