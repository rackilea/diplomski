public static class CustomFragmentAdapter extends FragmentPagerAdapter 
        implements TitleProvider {

        public static final int POSITION_PAGE_1 = 0;
        public static final int POSITION_PAGE_2 = 1;
        public static final int POSITION_PAGE_3 = 2;

        private static final String[] TITLES = new String[] { 
            "Title 1", 
            "Title 2", 
            "Title 3" 
        };

        public static final int NUM_TITLES = TITLES.length;

        public CustomFragmentAdapter(FragmentManager fm) {      
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {     
            switch (position) {
            case POSITION_TITLE_1:              
                return PageOneFragment.newInstance();
            case POSITION_TITLE_2: 
                return PageTwoFragment.newInstance();
            case POSITION_TITLE_3:
                return PageThreeFragment.newInstance();         
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_TITLES;
        }

        @Override
        public String getTitle(int position) {
            return TITLES[position % NUM_TITLES].toUpperCase();
        }
    }