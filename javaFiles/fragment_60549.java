private void initToolbar() {
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_prefs);
    setSupportActionBar(toolbar);        

    actionBar = getSupportActionBar();
    actionBar.setDisplayHomeAsUpEnabled(true);
    actionBar.setHomeButtonEnabled(true);
    actionBar.setTitle(R.string.activity_title_settings);
}