List<Card> cards;

List<Card> neverSeen = new ArrayList<>();
List<Card> missedMore = new ArrayList<>();
List<Card> other = new ArrayList<>();

for (Card card : cards) {
    if (card.getMade() == 0 && card.getMissed() == 0) {
        neverSeen.add(card);
    } else if (card.getMissed() > card.getMade()) {
        // Add about 1 in 10 to the beginning
        if (Math.random() < 0.1) {
            neverSeen.add(card);
        } else {
            missedMore.add(card);
        }
    } else {
        // Add about 1 in 20 to the beginning
        if (Math.random() < 0.05) {
            neverSeen.add(card);
        } else {
            other.add(card);
        }
    }
}

Collections.shuffle(neverSeen);
Collections.shuffle(missedMore);
Collections.shuffle(other);

neverSeen.addAll(missedMore);
neverSeen.addAll(other);

cards = neverSeen;