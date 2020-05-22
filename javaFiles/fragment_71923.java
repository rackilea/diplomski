public class Bank {
    private int nextAccountId = 1;

    public int createAccount(String owner) {
        // Get account ID
        int accountId = getUniqueAccountId();

        // Create account
        ...

        return accountID;
    }

    private int getUniqueAccountId() {
        int accountId = nextAccountId;
        // Increment ID for next request
        nextAccountId++;

        return accountId;

        // Method can be made compact by just using
        // return nextAccountId++;
    }
}