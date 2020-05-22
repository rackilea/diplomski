public Integer getNextAccountID() {
    /*this is a helper method that can be used to find out what the next 
     * accountID will be based on the number of Accounts within the accounts Map.
     * It should return the size of the accounts Map plus one.
     */ 

    return accounts.size() + 1;
}