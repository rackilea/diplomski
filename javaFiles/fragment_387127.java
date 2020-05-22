@Override
public boolean onContextItemSelected(MenuItem item) {
    AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();

    switch(item.getItemId()) {
        case MY_OPTION_CONTEXT_MENU:
            TextView v = (TextView) info.targetView;
            // more code here
            return true;
    }

    return super.onContextItemSelected(item);
}