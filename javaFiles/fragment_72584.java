public abstract class Account {
    protected String Id;
    protected double balance;

    public Account(String Id, double balance) {
        this.Id = Id;
        this.balance = balance;
    }
}

public class CheckingAccount {
    // overwrite existing field
    protected double balance;

    public CheckingAccount(String Id, double balance) {
        super(Id, balance);
        this.balance = balance;
        if(super.balance > 10_000) this.balance += 200;
    }
}