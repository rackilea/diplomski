TabLayout tabLayout = findViewById(R.id.RestauranTabs);
tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
tabLayout.setTabMode(TabLayout.MODE_FIXED);

//adding the default one
tabLayout.addTab(tabLayout.newTab().setText(R.string.description));

if (!Restauran.getComments_enabled()) {
    tabLayout.addTab(tabLayout.newTab().setText(R.string.comments));
}else{
    tabLayout.setVisibility(View.GONE);
}

//rest goes as it is
final ViewPager viewPager = findViewById(R.id.RestauranViewpager);
final RestauranPagerAdapter adapter = new RestauranPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
viewPager.setAdapter(adapter);
viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
viewPager.setOffscreenPageLimit(3);

FloatingActionButton fabGoToMap = findViewById(R.id.fabGoToMap);
fabGoToMap.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});