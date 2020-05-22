public boolean onContextItemSelected(MenuItem item) {
    AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
    int position = info.position;

    // Here you will do things like Object selectedObject = myList.get(position);
    // And your server stuffs.
}