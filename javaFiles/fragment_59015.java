class LoanFactory{

    public static ICapitalStrategy getComplexLoan(){
        return new ComplexLoan();
    }
}