private void populateTabStrip() {
    final PagerAdapter adapter = mViewPager.getAdapter();
    final OnClickListener tabClickListener = new TabClickListener();



    for (int i = 0; i < adapter.getCount(); i++) {
        View tabView = null;
        TextView tabTitleView = null;

        if (mTabViewLayoutId != 0) {
            // If there is a custom tab view layout id set, try and inflate it
            tabView = LayoutInflater.from(getContext()).inflate(mTabViewLayoutId, mTabStrip,
                    false);
            tabTitleView = (TextView) tabView.findViewById(mTabViewTextViewId);
        }

        if (tabView == null) {
            tabView = createDefaultTabView(getContext());
        }

        if (tabTitleView == null && TextView.class.isInstance(tabView)) {
            tabTitleView = (TextView) tabView;
        }

        if (mDistributeEvenly) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) tabView.getLayoutParams();
            lp.width = 0;
            lp.weight = 1;
        }

        tabTitleView.setText(adapter.getPageTitle(i));
        tabView.setOnClickListener(tabClickListener);
                    tabTitleView.setTextColor(getResources().getColorStateList(R.drawable.selector));
        String desc = mContentDescriptions.get(i, null);
        if (desc != null) {
            tabView.setContentDescription(desc);
        }

        mTabStrip.addView(tabView);
        if (i == mViewPager.getCurrentItem()) {
            tabView.setSelected(true);
        }
    }
}