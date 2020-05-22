AppBarLayout appBarLayout;
appBarLayout = findViewById(R.id.appBarMainActivity);
...
public void onTabSelected(TabLayout.Tab tab) {
    viewPager.setCurrentItem(tab.getPosition());
    appBarLayout.setExpanded(true);
}