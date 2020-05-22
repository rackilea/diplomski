protected void onListItemClick(ListView l, View v, int position, long id) {
    super.onListItemClick(l, v, position, id);
    Cursor c = mNotesCursor;
    ListView mListView = getListView();
    firstPosition = mListView.getFirstVisiblePosition(); // changed this line
    c.moveToPosition(position);
    Intent i = new Intent(this, QuoteEdit.class);
    i.putExtra(QuotesDBAdapter.KEY_ROWID, id);
    i.putExtra(QuotesDBAdapter.KEY_QUOTES, c.getString(
    c.getColumnIndexOrThrow(QuotesDBAdapter.KEY_QUOTES)));
    startActivityForResult(i, ACTIVITY_EDIT);
    mListView.setSelection(firstPosition);
}