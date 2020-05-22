class MyTabListener implements ActionBar.TabListener {
    private int mTabPosition;

    public MyTabListener(int tabPosition) {
        mTabPosition = tabPosition;
    }

    @Override
    public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction arg1) {
        int tabPosition = tab.getPosition();
        // If we're trying to select this already-selected tab, bail out.
        if (tabPosition == mTabPosition) return;
        switch (tabPosition) {
        case 0:
            Intent startFeedActivity = new Intent(
                    MainActivity.this, EventFeed.class);
            startActivity(startFeedActivity);
            break;
        case 1: {
            Intent startWideActivity = new Intent(MainActivity.this,
                    WideView.class);
            startActivity(startWideActivity);
            break;
        }
        case 2:
            setContentView(R.layout.event_feed);
            break;
        }

    }

    @Override
    public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }
}