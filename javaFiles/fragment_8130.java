public boolean addAccount(String accountName, int accountNumber, double accountBalance) {
    boolean found=false;
    for (Account acc : accountList)
        if (acc.getAccountName().equals(accountName))
           found=true; 
    if(!found){
        accountList.add(new Account(accountName,accountNumber,accountBalance));
        return true;
    }
    return false;
}