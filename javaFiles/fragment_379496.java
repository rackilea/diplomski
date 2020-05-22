OnPageChangeListener pageChangeListener = new OnPageChangeListener() {
    @Override
    public void onPageScrollStateChanged(int arg0) { }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) { }

    @Override
    public void onPageSelected(int position) {

        switch (position) {
        case 0: 
                Log.e(TAG, "selected page = " + position);
            break;

        default:

                Log.e(TAG, "selected page = " + position);
            break;
        }
    }
});
mViewPager.setOnPageChangeListener(pageChangeListener);
pageChangeListener.onPageSelected(0);