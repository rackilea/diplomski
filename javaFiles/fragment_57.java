public class MinorBankAccount implements BankAccount {

    private static final int MINOR_ACCOUNT_TRANSACTION_LIMIT = 20;

    public boolean isTransactionAllowed(int amount) {
        return amount <= MINOR_ACCOUNT_TRANSACTION_LIMIT;
    }

}