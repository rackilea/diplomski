List<Account> accountList = new ArrayList<Account>();
// creditaccount
Account account = new CreditAccount();
list.add(account); // <-- adds the creditAccount to the list

// savingsaccount
account = new SavingsAccount(); // <-- reuse account
list.add(account); // <-- adds the savingsAccount to the list