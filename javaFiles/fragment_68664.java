public abstract class FranchiseFeeStructure {
    private static final BigDecimal REGISTRATION_FEE = new BigDecimal(1500);

    public final BigDecimal calculateFee {
        BigDecimal monthlyFee = getMonthlyFee();
        // TODO compute
        return fee;
    }

    /**
     * Subclasses must implement this method to tell what their monthly fee is
     */
    protected abstract BigDecimal getMonthlyFee();
}

public class ST1 extends FranchiseFeeStructure {
    @Override
    protected BigDecimal getMonthlyFee(){
        return new BigDecimal(890);
    }
}