Realm realm = null;

try {
    realm = Realm.getDefaultInstance();
    //do things
} finally {
    if(realm != null) {
         realm.close();
    }
}