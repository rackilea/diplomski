public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        // ...
        // Use Card.getFace().getRank() and Card.getSuit().getOrder()
        // ...
    }
}