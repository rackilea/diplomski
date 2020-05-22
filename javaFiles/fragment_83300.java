package test;

public class Account {
    private static int currentAccountId = 0;
    private int accountId;

    public Account() {
        this.accountId = ++currentAccountId;
    }

    @Override
    public String toString() {
        return String.valueOf(this.accountId);
    }
}