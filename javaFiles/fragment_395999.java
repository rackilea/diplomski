public class AccountRepository {
    private final Collection<Account> accounts;
    public AccountRepository(Collection<Account> accounts) {
        this.accounts = accounts;
    }

    public Account getByName(String accountName) {
        // Note that this is very inefficient, and I would not recommend using it in real code
        for(Account account : this.accounts) {
            if(account.getName().equalsIgnoreCase(accountName)) {
                return account;
            }
        }
        // Note: Returning null vs throwing exception is out of scope of this example.
        return null;
    }

    public Iterator<Account> getAccounts() {
        return this.accounts.getIterator();
    }
}