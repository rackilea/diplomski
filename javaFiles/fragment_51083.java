@Override
public void onListItemClick(ListView listview, View view, int position, long id) {
    super.onListItemClick(listview, view, position, id);

    // get the item selected directly here
    Cursor c = (Cursor) listview.getAdapter().getItem(position);

    // get specific hymn text from database item result
    String hymnText = c.getString(c.getColumnIndex("hymn_text"));
    // or whatever you want to retrieve from database: authors, songs...
    String hymnAuthor = c.getString(c.getColumnIndex("hymn_author"));

    // do some stuff with the previous values as updating a TextView...
}