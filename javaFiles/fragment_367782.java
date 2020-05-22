public double removeAccount(int i) throws NullPointerException {
    if(bankAccounts[i] != null) {
        double result = bankAccounts[i].getBalance();
        bankAccounts[i] = null;
        return result;
    }

    else {
        return 0;
    }
}