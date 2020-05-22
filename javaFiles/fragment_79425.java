@Override
public boolean onQueryTextChange(String newText) {
    mSearchGuestListAdapter.getFilter().filter(newText, new Filter.FilterListener() {
        @Override
        public void onFilterComplete(int count) {
            if (count == 0) {
                // Show empty view...
            } else {
                // Show recyclerView...
            }
        }
    });

    // Don't call notifyDataSetChanged() or setFilter() here!
    // Adaper will notified by publishResults() method
    // mSearchGuestListAdapter.setFilter(newText);
    // mSearchGuestListAdapter.notifyDataSetChanged();

    return false;
}