public class Bank {
    private double interest_rate = 1.01; // interest rate 
    private Customer[] accounts = new Customer[1000]; // array to store accounts
    private int counter=0;

// adds new customer 
public void addAcc (String user, String pass, int accNum) {
    Customer accID = new Customer(user,pass,accNum);
    this.accounts[counter++] = accID; 
}