public synchronized WalletInfo generateAddress(GenerateWallet generateWallet) {

        final WalletInfo walletInfo = new WalletInfo();

        String walletName = generateWallet.getWalletName();

        String currencyName = generateWallet.getCurrencyName();

        WalletInfo walletInfoDb = iWalletInfoDao.getWalletInfoWithWalletNameAndCurrency(walletName, currencyName);

        if (walletInfoDb == null && genWalletMap.get(walletName) == null) {

            String currency = currencyName.toUpperCase();

            if (currency.equals("BITCOIN")) {

                final WalletManager walletManager = WalletManager.setupWallet(walletName);
                CountDownLatch finishedSetup = new CountDownLatch(1);

                walletManager.addWalletSetupCompletedListener((wallet) -> {

                    Address address = wallet.currentReceiveAddress();
                    WalletInfo newWallet = createWalletInfo(walletName, currencyName, address.toString());

                    // set the properties of the walletInfo
                    walletInfo.setId(newWallet.getId());
                    walletInfo.setName(newWallet.getName());
                    walletInfo.setAddress(newWallet.getAddress());
                    walletInfo.setCurrency(newWallet.getCurrency());

                    walletMangersMap.put(newWallet.getId(), walletManager);
                    genWalletMap.remove(walletName);
                    finshedSetup.countDown();
                });

                genWalletMap.put(walletName, walletManager);
                finishedSetup.await();
                return walletInfo;
            } else if (currency.equals("ETHEREUM")) {
                return walletInfo;
            } else {
                return walletInfo;
            }
        }

        return walletInfo;
    }