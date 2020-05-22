public Account retrieve(int accountId) { 
    /* returns a single Account with the specified accountID from the accounts Map.
     * If none is found, return null.
     */ 
    if(accounts.containsKey(accountId)) {
        return accounts.get(accountId);
    }
    return null;
}