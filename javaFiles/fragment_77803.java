public aspect BankTotalBalanceAspect {
    pointcut BankCheck(Bank bank): call(public * Bank.*(..)) && target(bank);

    Object around(Bank bank): BankCheck(bank) && !within(BankTotalBalanceAspect) {
        int balance = bank.getTotalBalance();
        Object result = proceed(bank);
        if (balance != bank.getTotalBalance()) {
            LOGGER.warn("The total balance of the bank is not equal.");
        } else {
            LOGGER.info("Ok");
        }
        return result;
    }    
}