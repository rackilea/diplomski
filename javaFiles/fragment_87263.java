@Override
public boolean onPrepareOptionsMenu(Menu menu) {
    MenuItem item;
    item = menu.findItem(R.id.menu_id_one);
    if (aBooleanVariable) {
        item.setEnabled(true);
    } else {
        item.setEnabled(false);
    }
    // More code...
    return super.onPrepareOptionsMenu(menu);
}

@Override
public boolean onOptionsItemSelected(MenuItem i) {
    // Code, calculations...
    // ...
    // ...
    return super.onOptionsItemSelected(i);
}