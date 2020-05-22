UsageStatsManager usm = (UsageStatsManager)this.getSystemService("usagestats");
    long time = System.currentTimeMillis();
    List<UsageStats> appList = usm.queryUsageStats(UsageStatsManager.INTERVAL_DAILY,  time - 1000*1000, time);
    if (appList != null && appList.size() > 0) {
        SortedMap<Long, UsageStats> mySortedMap = new TreeMap<Long, UsageStats>();
        for (UsageStats usageStats : appList) {
            mySortedMap.put(usageStats.getLastTimeUsed(), usageStats);
        }
        if (mySortedMap != null && !mySortedMap.isEmpty()) {
            currentApp = mySortedMap.get(mySortedMap.lastKey()).getPackageName();
        }
    }