public class SavingsAccount {
    private int AccountNumber;
    private String Customer;
    private double Balance;
    private double MinimumBalance;
    /**
     * constructor
     * @param Number the account's number.
     * @param Name the account holders name.
     * @param bal the balance available.
     */
    public void open (int Number, String Name,double bal) {
        AccountNumber=Number;
        Customer=Name;
        Balance=bal;
    }
    /**
     * sets Minimum Balance
     * @param minbal the Minimum Balance
     */
    public void setMinimumBalance (int minbal) {
        MinimumBalance=minbal;
    }
    /**
     *  returning Minimum Balance
     * @return it is returning Minimum Balance
     */
    public double getMinimumBalance() {
        return MinimumBalance;
    }
    /**
     * display the details of savings account
     */
    public void print()
    {
        System.out.println("The Account Number is:" +(AccountNumber));
        System.out.println("The name of the Customer is :" +(Customer));
        System.out.println("Available balance is :" +(Balance));
        System.out.println("Minimum Balance to be maintained is :" +
        (MinimumBalance));
    }

    public double getBalance(){
        return this.Balance;
    }
}


// testing of savings account
 class Savings1  {
    public static void main(String[]args) {
        SavingsAccount S1; //Object Reference
        S1= new SavingsAccount(); //Creating Object
        S1.open (256101,"Mr.Gates ", 5000);
        S1.setMinimumBalance (6000);
        S1.print();
        if ( S1.getBalance() < S1.getMinimumBalance())
            System.out.println("FINE IS IMPOSED");
    }

}