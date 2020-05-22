if (Account.balance >= a) {
    // Account.balance = Account.balance - a;
    Account.balance -= a;
} else {
    System.err.printf("%d is greater than %d and would be an overdraft%n",
            a, Account.balance);
}