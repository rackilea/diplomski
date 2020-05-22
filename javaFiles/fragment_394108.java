viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            textview.setText(position == 0 ? "Hello" : "World");
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });