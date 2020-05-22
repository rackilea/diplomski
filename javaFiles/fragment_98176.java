@Override
public void onDestroyView() {
    super.onDestroyView();
    Log.d(LOGTAG, String.format("onDestroyView(%s)", this));
    searchView.setOnQueryTextListener(null);
    searchView.setQuery("", true);
}