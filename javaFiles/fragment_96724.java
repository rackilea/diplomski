mTabHost = (TabHost) findViewById(android.R.id.tabhost);

    mPullToRefreshLayout= (ListView)findViewById(R.id.tab_1);
    mPullToRefreshLayout1 = (ListView)findViewById(R.id.tab_2);
    mPullToRefreshLayout2 = (ListView)findViewById(R.id.tab_3);

    listview = (ListView)findViewById(R.id.listview1);
    listview1 = (ListView)findViewById(R.id.listview2);
    listview2 = (ListView)findViewById(R.id.listview3);

    ActionBarPullToRefresh.from(this)
        // Mark All Children as pullable
        .allChildrenArePullable()
        // Set the OnRefreshListener
        .listener(this)
        // Finally commit the setup to our PullToRefreshLayout
        .setup(mPullToRefreshLayout);