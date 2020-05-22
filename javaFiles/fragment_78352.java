public class AccountHolderImpl implements AccountHolder {
    private Account account;
    public void setAccount(Account account) {
        this.account = account;
    }
    public Account getAccount() {
        return account;
    }
}