class Card {
    ...

    private Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card of(String rank, String suit) {
        if (!isCorrectSuit(suit)) {
            throw new IllegalArgumentException("incorrect suit");
        }

        final Card card;
        switch (Integer.valueOf(rank)) {
            case ACE:
                card = new Card(1, suit);
                break;
            case JACK:
                card = new Card(11, suit);
                break;
            case QUEEN:
                card = new Card(12, suit);
                break;
            case KING:
                card = new Card(13, suit);
                break;
            default: {
                throw new IllegalArgumentException("incorrect rank");
            }
        }
        return card;
    }
}