package test;

import java.util.Date;

public class Transaction {
    private static int currentTransactionId = 0;
    private final int transactionId;
    private final Account account;
    private final String type;
    private final double amount;
    private final Date dateTime;

    public Transaction(final Account account, final String type, final double amount) {
        this.account = account;
        this.type = type;
        this.amount = amount;
        this.dateTime = new Date();
        this.transactionId = ++currentTransactionId;
    }

    public int getTransactionId() {
        return this.transactionId;
    }

    public Account getAccount() {
        return this.account;
    }

    public String getType() {
        return this.type;
    }

    public double getAmount() {
        return this.amount;
    }

    public Date getDateTime() {
        return this.dateTime;
    }

    @Override
    public String toString() {
        return "Transaction: "
           + this.transactionId
           + "/ Account:"
           + this.account.toString()
           + " / Type:"
           + this.type
           + " / Amount:"
           + this.amount
           + " / Date:"
           + this.dateTime.toGMTString()
           + System.lineSeparator();
    }
}