toolbar = (Toolbar) findViewById(R.id.tool_bar);
if (toolbar != null) {
    // you can safely invoke methods on the Toolbar
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
} else {
    // Toolbar is null, handle it
}