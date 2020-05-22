// background thread
Realm realm = null;
try {
    realm = Realm.getDefaultInstance();
    final List<Contact> contacts = getContacts();
    realm.executeTransaction(new Realm.Transaction() {
        @Override
        public void execute(Realm realm) {
            realm.insertOrUpdate(contacts);
            realm.where(Contact.class)
                 .equalTo(ContactFields.IS_BEING_SAVED, false) // compile 'dk.ilios:realmfieldnameshelper:1.1.0'
                 .findAll()
                 .deleteAllFromRealm(); // delete all non-saved data
                        // in your case, this is where you'd handle the cascading too though manually
            for(Contact realmContact : realm.where(Contact.class).findAll()) { // realm 0.89.0+
                realmContact.setIsBeingSaved(false); // reset all save state
            }
        }
    });
} finally {
    if(realm != null) {
        realm.close();
    }
}