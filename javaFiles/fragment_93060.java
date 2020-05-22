// #################################################################### GUI

    TabLayout guiTabs;
    guiTabs = findViewById(R.id.guiTopNav);
    guiTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()) {
                    case 0: Toast.makeText(MainActivity.this, "Tab 1", Toast.LENGTH_LONG).show();
                    break;
                    case 1: Toast.makeText(MainActivity.this, "Tab 2", Toast.LENGTH_LONG).show();
                    break;
                    case 2: Toast.makeText(MainActivity.this, "Tab 3", Toast.LENGTH_LONG).show();
                    break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });