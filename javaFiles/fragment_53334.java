void someMehtod() {
    List<Account> accountList = new ArrayList<Account>();

    { // <-- start inner block
        Account account = new CreditAccount();
        accountList.add(account);
    } // <-- end inner block

    {
        Account account = new SavingsAccount();
        accountList.add(account);
    }

    account.toString() // compile time error as account is not visible!

}