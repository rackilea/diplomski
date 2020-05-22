RealmChangeListener<Account> listener = new RealmChangeListener() {
    @Override
    public void onChange(Account account) {
        // changes have been made to Account table
    }
}

Account mAccount;

mAccount = mRealmInstance.where(Account.class).equalTo("isLoggedIn", true).findFirst();
if(mAccount != null) {
    mAccount.addChangeListener(listener);
    //assuming I'm in a transaction here
    mAccount.setName("New Name");
}

...

if(mAccount.isValid()) {
    mAccount.removeAllChangeListeners();
}