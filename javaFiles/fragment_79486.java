class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private String tabTitles[];

    SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
        tabTitles = new String[]{
            mContext.getResources().getString(R.string.one),
            mContext.getResources().getString(R.string.two),
            mContext.getResources().getString(R.string.three),
            mContext.getResources().getString(R.string.four)
        };
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}