boolean isFlush(Card[] cards) {
    for(Card c : cards) {
        if(c.suit != cards[0].suit) return false;
    }
    return true;
}

/**
 * returns the value of the set, or 0 if no three-set exists
 */
int isThreeKind(Card[] cards) {
    for(int i = 0; i < cards.length - 2; i++) {
        if(sumOfType(i.value,cards) >= 3) return i.value; // return the value of the card
    }
    return 0; // 0 indicates no value
}

int sumOfType(int value, Card[] cards) {
    int sum = 0;
    for(Card c : cards) if(value == c.value) sum++;
    return sum;
}