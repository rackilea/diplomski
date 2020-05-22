public interface AccountDAO {
    public Account getAccount(String accountNumber);
    //and other methods
    public List<Account> getAllAccounts(); //this is not suitable for a real bank app
    public void writeAccount(Account account);
    public void deleteAccount(Account account);
    public void updateAccount(Account oldAccount, Account newAccount);
}