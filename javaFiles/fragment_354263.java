private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        String[] displayText;
        public ScreenSlidePagerAdapter(FragmentManager fm,String[] displayText) {
            super(fm);
            this.displayText=displayText;
        }

        @Override
        public Fragment getItem(int position) {
            System.out.println("inside!");
            ScreenSlidePageFragment fragment = new ScreenSlidePageFragment(); 
            fragment.setText(displayTest[position]);
            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }    
    }