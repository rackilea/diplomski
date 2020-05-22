private void setCustomActionBar() {

    ActionBar mActionBar = this.getSupportActionBar();
    mActionBar.setDisplayShowHomeEnabled(false);
    mActionBar.setDisplayShowTitleEnabled(false);

    LayoutInflater mInflater = LayoutInflater.from(this);
    View mCustomView = mInflater.inflate(R.layout.custom_main_actionbar, null);

    mActionBar.setCustomView(mCustomView);
    mActionBar.setDisplayShowCustomEnabled(true);

    actionBarTitle = (TextView) mCustomView.findViewById(R.id.action_bar_title_tv);
    actionBarHomeBtn = (ImageView) mCustomView.findViewById(R.id.action_bar_app_icon);
    actionBarSyncBtn = (ImageView) mCustomView.findViewById(R.id.action_bar_sync_btn);
    actionBarSearchBtn = (ImageView) mCustomView.findViewById(R.id.action_bar_search_btn);
    actionBarHomeBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
                mDrawerLayout.closeDrawer(mDrawerList);
            } else {
                mDrawerLayout.openDrawer(mDrawerList);
            }
        }
    });

    actionBarSyncBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });

    actionBarSearchBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });
}