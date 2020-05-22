public enum Suit {
    HEARTS("of hearts");
    private String toString;
    public Suit(String toString) {
        this.toString = toString;
    }
    @Override
    public String toString() {
        return toString;
    }
}