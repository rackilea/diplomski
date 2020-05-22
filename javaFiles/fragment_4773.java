public class Loan {
    private String totalpaymentamt;

    public Loan() {

        this.totalpaymentamt = "\t toString() results"
                + this.toString(this.getDuration(),
                        this.getInterestRate(),
                        this.gettotalAmount())
                + "  \n \t getNumberOfYears() results:"
                + this.getDuration()
                + " getInterestRate() results:"
                + this.getInterestRate()
                + "  getTotalAmount() results:"
                + this.gettotalAmount()
                + " getMonthlyPayment:"
                + this.getMonthlyPayment(this.getDuration(),
                        this.getInterestRate(),
                        this.gettotalAmount());

    }


    public String getTotalPaymentAmount() {
        return this.totalpaymentamt;
    }
}