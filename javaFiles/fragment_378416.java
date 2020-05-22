public class Hand {
    ...

    public List<Card> getSortedCards() {
        Collections.sort(cards);
        return cards; // Consider deep copying.
    }
}