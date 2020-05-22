public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           if(position==0){
              return SubPage01.newInstance(position + 1);
           }else if(position==1){
              return SubPage02.newInstance(position + 1);
           }else{
              return SubPage03.newInstance(position + 1);
           }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Page 01";
                case 1:
                    return "Page 02";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
}