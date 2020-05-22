int pos;//to track the current page
mPager.setOnPageChangeListener(new OnPageChangeListener() {

    @Override
    public void onPageSelected(int position) {
        pos=position;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
});