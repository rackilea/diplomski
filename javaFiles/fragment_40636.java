public void builtListView() {
    _translist.clear();
    DatabaseAdapter mDbHelper = new DatabaseAdapter(this);
    mDbHelper.createDatabase();
    mDbHelper.open();
    TransactionRecController trc = new TransactionRecController(
            mDbHelper.open());

    ArrayList<TransactionRecModel> trans_list = trc
            .getTransactionRec(session_userID);

    for (int i = 0; i < trans_list.size(); i++) {
        String date = trans_list.get(i).getDate();
        String categoryName = trans_list.get(i).getCategory();
        String transDesc = trans_list.get(i).getTransDescription();

        TransactionRecModel _TransModel = new TransactionRecModel();

        _TransModel.setDate(date);
        _TransModel.setCategory(categoryName);
        _TransModel.setTransDescription(transDesc);

        _translist.add(_TransModel);
    }
    // Set the data into listview
    listview.setAdapter(new ListAdapter(this));

    mDbHelper.close();
}