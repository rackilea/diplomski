public synchronized WalletInfo generateAddress(CreateWalletWithNameAndCurrency createWalletWithNameAndCurrency) {

        String walletName = createWalletWithNameAndCurrency.getWalletName();

        String currencyName = createWalletWithNameAndCurrency.getCurrencyName();

        WalletInfo walletInfo = iWalletInfoDao.getWalletInfoWithWalletNameAndCurrency(walletName, currencyName);


    // some more code 
}