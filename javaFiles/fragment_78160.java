public boolean deposit(long pNr, int accountId, double amount){
    for(Customer customer : customerlist)
    {
        if(pNr == customer.getPNr())
        {
            for(SavingsAccount account : accounts)
            {
                if(accountId == account.getAccountId())
                {
                    balance += amount;
                    return true;
                }
            }
            return false;
        }
    }
    return false;
}