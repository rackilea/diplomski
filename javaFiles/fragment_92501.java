public boolean store(Account account) {
    /* adds a new Account to the accounts Map. The key is the account’s ID. This
     * method should return a Boolean object that is "true" when the Account added
     * to the ledger is being added for the first time, "false" if it is being
     * updated. Check the documentation for the Map.put() method for reference.
     */
    int key = account.getAccountID();
    if(accounts.containsKey(key) != null){
        accounts.put(key, account);
        return true;
    }
    return false;
}