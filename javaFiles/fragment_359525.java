package myatm;

public interface Account {
    public double getBalance(); // returns current balance

    public double withdrow(double amount); // returns the sum which was taken.
}