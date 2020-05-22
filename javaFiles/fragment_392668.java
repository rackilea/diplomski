volley = MySingleton.getInstance(getApplicationContext());
mRequestQueue = volley.getRequestQueue();

Intent intent = getIntent();
if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
    String query = intent.getStringExtra(SearchManager.QUERY);
    search(query);
}