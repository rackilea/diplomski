private void addDrawerItems() {
    final String[] osArray;
    if(cookie.contains("androidlogin")) {
        osArray = new String[]{ "item 1", "item 2", "Logout" };
    } else {
        osArray = new String[]{ "item 1", "item 2" };
    }
    mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
    ...
}