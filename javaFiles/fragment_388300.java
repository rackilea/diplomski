private void downloadUpdateDatabase(final String uid, final String location_address) throws RealmException
{
    mRealm.executeTransactionAsync(new Realm.Transaction() {
        @Override
        public void execute(Realm realm) {
            ARDatabase db = realm.where(ARDatabase.class).equalTo("uid", uid).findFirst();
            db.setIsDownloaded(true);
            db.setLocation(location_address);
        }
    }, new Realm.Transaction.OnSuccess() {
        @Override
        public void onSuccess() {
            // Transaction was a success.
        }
    }, new Realm.Transaction.OnError() {
        @Override
        public void onError(Throwable error) {
            // Transaction failed and was automatically canceled.
        }
    });
}