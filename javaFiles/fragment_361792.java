userWalletDao.getUnregisteredUserWallets()
                .flatMap(nextWallet -> registerUserWallet(nextWallet.getUserId()).toObservable()
                        .flatMap(address -> Observable.fromCallable(() -> new Pair<>(nextWallet, address))))  // return both wallet from previous mapping and address from current mapping to the next level
                .flatMapCompletable(walletAddressPair -> Completable.fromAction(()->{
                    Wallet nextWallet = walletAddressPair.first;
                    String address = walletAddressPair.second;
                    nextWallet.setAddress(address);
                    userWalletDao.persistUserWalletAddress(nextWallet);
                    log.info("Registered wallet {} with address {}.", nextWallet, address);
                    // here wallet and address have been saved to db. This operation is a completable action, you don't have to return any result 
                    // from it and forward to the next level.  Thats why flatMapCompletable is used.
                }))
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                       // All actions completed
                    }

                    @Override
                    public void onError(Throwable e) {
                      // any error occurred in the observable chain
                    }
                });