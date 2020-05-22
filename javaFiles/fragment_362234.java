public boolean onContextItemSelected(MenuItem item) {
    AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
            .getMenuInfo();
    if (item.getTitle() == "Delete ") {
        mArray.remove(currentposition);
        ca.notifyDataSetChanged();
        Toast.makeText(this, "Deleted ", Toast.LENGTH_SHORT)
                .show();
    } 
    return true;
}