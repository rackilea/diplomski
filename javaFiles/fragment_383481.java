private void  openSearch() {
    Toast.makeText(this, "Search button pressed", Toast.LENGTH_SHORT).show();
}

private void  openSettings()  {
    startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
}
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle presses on the action bar items
    switch (item.getItemId()) {
        case R.id.action_search:
            openSearch();
            return true;
        case R.id.action_settings:
            openSettings();
        return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}