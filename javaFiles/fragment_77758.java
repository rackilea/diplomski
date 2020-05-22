@Override
public void updateAll(final Fragment fragment) {
    final long startTime = System.nanoTime();
    final RealmResults<Stock> realmResults = realm.where(Stock.class).findAll();
    Log.d(Constants.LOG_TAG, "All rows [" + realmResults.size() + "] selected and fetched into RealmResults. Called 'execute' callback.");

    realm.executeTransactionAsync(new Realm.Transaction() {
        @Override
        public void execute(Realm realm) {
            for (Stock stock : realmResults) {
                stock.setDate("1");
                stock.setAdjClose(2);
                stock.setVolume(3);
                stock.setHigh(4);
                stock.setLow(5);
                stock.setOpen(6);
                stock.setClose(7);
            }
        }
    }, new Realm.Transaction.OnSuccess() {
        @Override
        public void onSuccess() {
            Log.d(Constants.LOG_TAG, "All rows updated. Called 'onSuccess' callback.");
            ((RealmFragment) fragment).stopBenchmark(startTime, System.nanoTime());
        }
    });
}