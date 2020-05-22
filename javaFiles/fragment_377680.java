public class ChargesAndFees {
    private static final ZERO = new ChargesAndFees(BigDecimal.ZERO, BigDecimal.ZERO);

    private final BigDecimal charges;
    private final BigDecimal fees;

    // constructor and getters

    public ChargesAndFees add(ChargesAndFees that) {
        return new ChargesAndFees(this.charges.add(that.charges),
                                  this.fees.add(that.fees));
    }
}