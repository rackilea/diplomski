Realm realm = null;
try {
    realm = Realm.getDefaultInstance();
    //do database operations
} finally {
    if(realm != null) {
        realm.close();
    }
}