private void downloadUpdateDatabase(String uid,String location_address) throws RealmException
{
    mRealm.beginTransaction();
    ARDatabase db = mRealm.where(ARDatabase.class).equalTo("uid", uid).findFirst();
    db.setIsDownloaded(true);
    db.setLocation(location_address);
    mRealm.copyToRealmOrUpdate(db);
    mRealm.commitTransaction();
}