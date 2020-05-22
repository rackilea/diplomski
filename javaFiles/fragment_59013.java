class LoanFactory{

    public static double getComplexLoan(Loan l){
        return new ComplexLoan().CapitalLoan(l);
    }
}