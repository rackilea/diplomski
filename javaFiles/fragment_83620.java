mMyActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

ActionBar.Tab mFirstTab = mMyActionBar.newTab();
mFirstTab.setText("First Tab");
mFirstTab.setTabListener(this);
mMyActionBar.addTab(mFirstTab);

ActionBar.Tab mSecondTab = mMyActionBar.newTab();
mSecondTab.setText("Second Tab");
mSecondTab.setTabListener(this);
mMyActionBar.addTab(mSecondTab);

ActionBar.Tab mThirdTab = mMyActionBar.newTab();
mThirdTab.setText("Third Tab");
mThirdTab.setTabListener(this);
mMyActionBar.addTab(mThirdTab);