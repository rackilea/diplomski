viewPager.setOnPageChangeListener(new OnPageChangeListener() {
    public void onPageScrollStateChanged(int state) {}
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    public void onPageSelected(int position) {
        if(position == 1)
            displayInterstitial();
    }
});