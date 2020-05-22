public class Service {
    public void transferMoney(Account fromAcct, Account toAcct, int amount) {
        fromAcct.credit(amount);
        toAccount.debit(amount);
    }
}

class Account {
    private final object syncObject = new Object();
    private int amount = 0;

    public void credit(int sum) {
        synchronized(syncObject) {
            amount = amount + sum;
        }
    }

    public void debit(int sum) {
        synchronized(syncObject) {
            amount = amount - sum;
        }
    }
}