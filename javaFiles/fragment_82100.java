mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
            FragmentStackSupport.CountingFragment.class, null);
    mTabHost.addTab(mTabHost.newTabSpec("contacts").setIndicator("Contacts"),
            LoaderCursorSupport.CursorLoaderListFragment.class, null);
    mTabHost.addTab(mTabHost.newTabSpec("custom").setIndicator("Custom"),
            LoaderCustomSupport.AppListFragment.class, null);
    mTabHost.addTab(mTabHost.newTabSpec("throttle").setIndicator("Throttle"),
            LoaderThrottleSupport.ThrottledLoaderListFragment.class, null);