//Load the appropriate layout
if (useTabletMenu()){
    setContentView(artlvlup.how.to.draw.R.layout.activity_main_tablet);
    Helper.setStatusBarColor(MainActivity.this,
    ContextCompat.getColor(this, artlvlup.how.to.draw.R.color.myPrimaryDarkColor));
} else {
    setContentView(artlvlup.how.to.draw.R.layout.activity_main);
}