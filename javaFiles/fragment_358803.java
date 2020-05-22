class CashFlow {
    private final double initialDeposit;
    private final double rate;
    private final int years;
    private final double monthlyContribution;
    private final int interestFrequency;

    CashFlow(double initialDeposit, double rate, int years,
             double monthlyContribution, int interestFrequency) {
        if ( years < 1 ) {
            throw new IllegalArgumentException("years must be at least 1");
        }

        if ( rate <= 0 ) {
            throw new IllegalArgumentException("rate must be positive");
        }

        if ( 12 % interestFrequency != 0 ) {
            throw new IllegalArgumentException("frequency must divide 12");
        }

        this.initialDeposit = initialDeposit;
        this.rate = rate;
        this.years = years;
        this.monthlyContribution = monthlyContribution;
        this.interestFrequency = interestFrequency;
    }

    public double terminalValue() {
        final int interestPeriod = 12 / interestFrequency;
        final double pRate = Math.pow(1 + rate, 1.0 / interestPeriod) - 1;
        double value = initialDeposit;

        for ( int i = 0; i < years * 12; ++i ) {
            value += monthlyContribution;

            if ( i % interestFrequency == interestFrequency - 1 ) {
                value *= 1 + pRate;
            }  
        }

        return value;
    }
}

class CompoundCalc {

    public static void main(String[] args) {
        CashFlow cf = new CashFlow(5000, 0.05, 30, 400, 3);
        System.out.println("Terminal value: " + cf.terminalValue());
    }
}