package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Runner {

    public static void main(final String[] args) {
        List<Account> accounts = new ArrayList<Account>();
        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        Queue<Transaction> transactions = new LinkedList<Transaction>();
        transactions.add(new Transaction(account1, "CREDIT", 10d));
        transactions.add(new Transaction(account1, "CREDIT", 20d));
        transactions.add(new Transaction(account2, "CREDIT", 5d));
        transactions.add(new Transaction(account3, "CREDIT", 8d));
        transactions.add(new Transaction(account1, "DEBIT", 3d));

        List<Transaction> account1Transactions = new ArrayList<Transaction>();
        for (Transaction transaction : transactions) {
            if (transaction.getAccount().equals(account1)) {
                account1Transactions.add(transaction);
            }
        }
        System.out.println(Arrays.toString(account1Transactions.toArray()));
    }

}