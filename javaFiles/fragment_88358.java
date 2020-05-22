private Context mContext;

    public Adapter(Context ctx,boolean horizontal, boolean pager, List<App> apps) {
        mHorizontal = horizontal;
        mApps = apps;
        mPager = pager;
        this.mContext=ctx; // Call here


}