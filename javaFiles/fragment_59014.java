class ComplexLoan implements ICapitalStrategy{
    private ComplexLoan(){
    }

    public static double getLoan(Loan l){
        return new ComplexLoan().CapitalLoan(l);
    }
}