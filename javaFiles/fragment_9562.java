public static enum CardSuit {
    SPADE(0), HEART(1), DIAMOND(4), CLUB(2);
    int value;

    CardSuit(int v) {
        this.value = v;
    }

    public String toString() {
        return this.name();
    }

    public static CardSuit byValue(int value) {
        for (CardSuit cs : CardSuit.values()) {
            if (cs.value == value) {
                return cs;
            }
        }
        return null;
    }
}

public static void main(String[] args) {
    CardSuit s = CardSuit.byValue(2);
    System.out.println(s);
}