public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return SampleFragment.newInstance("Page # 1",false);
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return SampleFragment.newInstance( "Page # 2",true);
                case 2: // Fragment # 1 - This will shw SecondFragment
                    return SampleFragmentMulticity.newInstance( "Page # 3",false);
                default:
                    return null;
            }
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }