@Override
public boolean onCreateOptionsMenu(Menu menu) {

    getMenuInflater().inflate(R.menu.menu_main, menu);

    SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

    SearchView search = (SearchView) menu.findItem(R.id.action_search).getActionView();

    SearchableInfo si = manager.getSearchableInfo(getComponentName());

    //Here is where the magic happens:
    int options = search.getImeOptions();
    search.setImeOptions(options|EditorInfo.IME_FLAG_NO_EXTRACT_UI);
    //!!!!!!!!!!!

    search.setSearchableInfo(si);

    search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String query) {
            return true;
        }

    });
    return true;
}