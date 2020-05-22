Realm realm = null;
try {
    realm = Realm.getDefaultInstance();
    realm.executeTransaction(new Realm.Transaction() {
       // ... actual transaction code here
    });
} finally {
    if(realm != null) {
        realm.close();
    }
}