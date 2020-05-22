public class Account {
    private int balance = 0;

    public int getBalance() {
        return balance;
    }

    public void insert(int amount) {
        if(amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(int amount) {
        if(amount > 0 && amount =< balance) {
            balance -= amount;
        }
    }
}