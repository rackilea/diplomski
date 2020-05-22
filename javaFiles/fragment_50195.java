public static CardDeck createStandardDeck() {
    CardDeck myDeck = new CardDeck(13*4);
    for (int i = 1; i <= 13; i++) { myDeck.deck.push(new Card(Card.Color.CLUBS,i)); }
    for (int i = 1; i <= 13; i++) { myDeck.deck.push(new Card(Card.Color.DIAMONDS,i)); }
    for (int i = 1; i <= 13; i++) { myDeck.deck.push(new Card(Card.Color.HEARTS,i)); }
    for (int i = 1; i <= 13; i++) { myDeck.deck.push(new Card(Card.Color.SPADES,i)); }
    return myDeck;
}