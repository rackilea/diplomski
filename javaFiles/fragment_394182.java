Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_acashmemoreport);
setSupportActionBar(toolbar);


if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
    Window window = getWindow();
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
    window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
}

// Show menu icon
final ActionBar actionBar = getSupportActionBar();
actionBar.setDisplayHomeAsUpEnabled(true);
getSupportActionBar().setDisplayShowTitleEnabled(true);
toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));