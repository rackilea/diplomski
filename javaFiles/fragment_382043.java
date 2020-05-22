for (int i = 0; i < tabLayout.getTabCount(); i++) {

    TabLayout.Tab tab = tabLayout.getTabAt(i);
    if (tab != null) {

        TextView tabTextView = new TextView(this);
        tab.setCustomView(tabTextView);

        tabTextView.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
        tabTextView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;

        tabTextView.setText(tab.getText());

        if (i == 0) {
            tabTextView.setTextSize(16);
        }

    }

}
tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        ViewGroup vgTab = (ViewGroup) vg.getChildAt(tab.getPosition());
        int tabChildsCount = vgTab.getChildCount();
        for (int i = 0; i < tabChildsCount; i++) {
            View tabViewChild = vgTab.getChildAt(i);
            if (tabViewChild instanceof TextView) {
                ((TextView) tabViewChild).setTextSize(16);
            }
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        ViewGroup vgTab = (ViewGroup) vg.getChildAt(tab.getPosition());
        int tabChildsCount = vgTab.getChildCount();
        for (int i = 0; i < tabChildsCount; i++) {
            View tabViewChild = vgTab.getChildAt(i);
            if (tabViewChild instanceof TextView) {
                ((TextView) tabViewChild).setTextSize(14);
            }
        }
    }
}