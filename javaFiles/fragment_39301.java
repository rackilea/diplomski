@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.YOUR_MENU, menu);

    MenuItem item = menu.findItem(R.id.searchMenu);
    SearchView searchView = (SearchView) item.getActionView();
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextChange(String newText) {
            itemAdapter.getFilter().filter(newText);
            return true;
        }
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }
    });
    return super.onCreateOptionsMenu(menu);
}