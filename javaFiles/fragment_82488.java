@Override
public void onCreateContextMenu (ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    ...
    // The parameter v is the actual tab view and not the TabWidget
    // this makes it easy to get the indicator text or its tag in order
    // to easily identify which tab was long-clicked and build the menu
    ...
}

@Override
public boolean onContextItemSelected (MenuItem item) {
    ...
    // Process selected item here
    ...
}