viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int arg0) {
            // Check if your "Mapa" Fragment is selected, it's probably on position one
            if (arg0 == 1) {
               mMapaFragment.setupMap():
            }   
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }
    });