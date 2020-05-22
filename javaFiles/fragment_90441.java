private void init() {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
        return;
    }
    addOnPageChangeListener(new OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            MainActivity.SectionsPagerAdapter adapter =
                // Your adapter name goes here
                ((MainActivity.SectionsPagerAdapter) getAdapter());
            adapter.invalidateFragment(position);
        }

        @Override
        public void onPageScrollStateChanged(int position) {
        }
    });
}