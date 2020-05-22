@Override
public boolean onContextItemSelected(MenuItem item) {
    AdapterView.AdapterContextMenuInfo info = 
        (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

            Track track = (Track)mAdapter.getItem(info.position);