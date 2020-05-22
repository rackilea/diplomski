int suit = cards[0].getSuit();
for (int i = 1; i < cards.length; ++i) {
    if (suit != cards[i].getSuit()) // checks to see if you have a card of a different suit
        return false;
}
return true; // suits of all cards are the same