//after commitTransaction, 

RealmResults<Transactions> allTransactions = realm.where(Transactions.class).findAllSorted("createdAt");

//If you have an incrementing id column, do this
long lastInsertedId = allTransactions.last().getId();