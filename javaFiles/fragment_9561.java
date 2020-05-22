public static enum CardSuit {
    SPADE(0), HEART(1), DIAMOND(2), CLUB(3);
    int value;

    CardSuit(int v) {
        this.value = v;
    }

    public String toString() {
        return this.name();
    }
}

public static void main(String[] args) {
    CardSuit s = CardSuit.values()[0];
    System.out.println(s);
}