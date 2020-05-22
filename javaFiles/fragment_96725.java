public void onTabChanged(String tabId) {

    for(int i=0;i<mTabHost.getTabWidget().getChildCount();i++)
    {
        mTabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.WHITE);
    }


    if (TAB_1.equals(tabId)) {
       // updateTab(R.id.tab_1);
        mCurrentTab = 0;
        //Toast.makeText(getApplicationContext(), "1No Guest list for Today", Toast.LENGTH_SHORT).show();
        mTabHost.getTabWidget().getChildAt(mTabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#fff498"));

ActionBarPullToRefresh.from(this)
        // Mark All Children as pullable
        .allChildrenArePullable()
        // Set the OnRefreshListener
        .listener(this)
        // Finally commit the setup to our PullToRefreshLayout
        .setup(mPullToRefreshLayout);


    }
    if (TAB_2.equals(tabId)) {
        //updateTab(R.id.tab_2);
         mCurrentTab = 1;
         //Toast.makeText(getApplicationContext(), "2No Guest list for Today", Toast.LENGTH_SHORT).show();
         mTabHost.getTabWidget().getChildAt(mTabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#fff498"));
        //http://192.168.21.74/mynetwork/formapi/trending
        //http://192.168.21.74/mynetwork/formapi/popular

ActionBarPullToRefresh.from(this)
        // Mark All Children as pullable
        .allChildrenArePullable()
        // Set the OnRefreshListener
        .listener(this)
        // Finally commit the setup to our PullToRefreshLayout
        .setup(mPullToRefreshLayout1);
    }
    if (TAB_3.equals(tabId)) {
        //updateTab(R.id.tab_2);
         mCurrentTab = 2;
        // Toast.makeText(getApplicationContext(), "3No Guest list for Today", Toast.LENGTH_SHORT).show();
         mTabHost.getTabWidget().getChildAt(mTabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#fff498"));
   ActionBarPullToRefresh.from(this)
        // Mark All Children as pullable
        .allChildrenArePullable()
        // Set the OnRefreshListener
        .listener(this)
        // Finally commit the setup to our PullToRefreshLayout
        .setup(mPullToRefreshLayout2);
    }
}