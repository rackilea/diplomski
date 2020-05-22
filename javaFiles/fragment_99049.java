// ListView l points to list view whose item user clicked
// View v points to the item in the list view on which the user clicked
// int position is the position index of the item in the list
// long id is the id assigned to the item. This id is assigned using the ListAdapter, CursorAdapter etc.
@Override
protected void onListItemClick(ListView l, View v, int position, long id) {
    super.onListItemClick(l, v, position, id);

    // I am using getApplicationContext() as it is more safe then just passing `this`
    Intent i = new Intent(this.getApplicationContext(), ActivityToRun.class);

    this.startActivity(i);
}