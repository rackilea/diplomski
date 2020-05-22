public Card(int rank, String suit) {
    if (!isCorrectSuit(suit)) {
        throw new IllegalArgumentException("incorrect suit");
    }

    if (!isCorrectRank(rank)) {
        throw new IllegalArgumentException("incorrect rank");
    }

    this.rank = rank;
    this.suit = suit;
}

public Card(String rank, String suit) {
    this(Integer.valueOf(rank), suit);
}