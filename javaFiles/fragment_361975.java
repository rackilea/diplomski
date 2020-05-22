@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.search, menu);

    MenuItem item = menu.findItem(R.id.action_search);
    searchView.setMenuItem(item);
    searchView.performClick();
    return true;
}