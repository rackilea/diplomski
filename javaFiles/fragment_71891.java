toolBar = (Toolbar) findViewById(R.id.appBar);
toolBar.setTitle("Titolo");
setSupportActionBar(toolBar);

tabLayout = (TabLayout) findViewById(R.id.tabLayout);
tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.user));
tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.user_group_1));
tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.user_group_2));