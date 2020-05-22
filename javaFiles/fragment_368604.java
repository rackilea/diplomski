private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == X) {
                getActivity().getActionBar().hide();
            }
            else {
                getActivity.getActionBar().show();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };