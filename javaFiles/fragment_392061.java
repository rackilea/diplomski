public class CreateWalletWithNameAndCurrency {

    String walletName;

    String currencyName;

    public CreateWalletWithNameAndCurrency(String walletName, String currencyName) {
        this.walletName = walletName;
        this.currencyName = currencyName;
    }

    public CreateWalletWithNameAndCurrency() {
    }

    public String getWalletName() {
        return walletName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }
}