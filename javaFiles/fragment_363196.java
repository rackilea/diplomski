public WithdrawalResult withdrawFromAccount(String accountId, int amountToWithdraw) {
    WithdrawalResult withDrawalResult = new WithdrawalResult();

    synchronized(hashMap) {
        Account account = hashMap.get(accountId);    
        if (account != null) {                           
            int balance = account.getBalance();
            if (balance >= amountToWithdraw) {              
                account.setBalance(balance - amountToWithdraw);
                withdrawalResult.setMessage("Withdrawn. You now have " +   tmpAccount.getBalance() + " left");
            } else {
                withdrawalResult.setMessage("Don't have the balance for your request. Only " + balance + " left");
            }
        } else {
            withdrawalResult.setMessage("Sorry: account id " + accountId + " does not exist");
        }
    }

    return withdrawalResult;
}