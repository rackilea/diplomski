public void builtListView() {
    _translist.clear();
    DatabaseAdapter mDbHelper = new DatabaseAdapter(this);
    mDbHelper.createDatabase();
    mDbHelper.open();
    TransactionRecController trc = new TransactionRecController(
            mDbHelper.open());

    _translist = trc
            .getTransactionRec(session_userID);

     // Set the data into listview
    listview.setAdapter(new ListAdapter(this));

    mDbHelper.close();
}