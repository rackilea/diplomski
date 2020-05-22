public Account createAccount(String accountType, String firstName, String lastName) {
    /* this method creates and returns a new Account object with the specified
     * parameters (type, firstName, lastName). Calling this method should store the
     * new account within the accounts Map. Please note the first parameter passed
     * into this method determines which account type (CheckingAccount vs.
     * SavingsAccount) to create. The values should either be “checking” or
     * “savings”.
     */

    int accountId = getNextAccountID();
    Account acc;
    if(type == "checking"){
      acc = new CheckingAccount(id, type, firstName, lastName);
    } else {
      acc = new SavingAccount(id, type, firstName, lastName);
    }
    return acc;
}