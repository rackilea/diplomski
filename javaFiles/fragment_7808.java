private void populateTabStrip() {
            ...
            tabTitleView.setText(MyActivity.pageTitle); 
            tabView.setOnClickListener(tabClickListener);

            mTabStrip.addView(tabView);

}