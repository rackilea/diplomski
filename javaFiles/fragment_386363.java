@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    // state for the first SearchView
    outState.putString("sv1", firstSearchView.getQuery().toString());
    // state for the second SearchView
    outState.putString("sv2", secondSearchView.getQuery().toString());
}

@Override
protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    // properly set the state to balance Android's own restore mechanism
    firstSearchView.setQuery(savedInstanceState.getString("sv1"), false);
    secondSearchView.setQuery(savedInstanceState.getString("sv2"), false);
}