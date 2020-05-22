public class Money {
    private final int dollars;
    private final int cents;
    private final Currency currency;

    public Money(int dollars, int cents, Currency curr) {
        if (dollars < 0) throw new IllegalArgumentException("dollars cannot be negative");
        if (cents < 0) throw new IllegalArgumentException("cents cannot be negative");
        if (curr == null) throw new IllegalArgumentException("currency cannot be null");
        this.dollars = dollars; 
        this.cents = cents;
        this.currency = curr;
    }
    // more methods here.
}