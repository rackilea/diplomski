public class YourPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

        private FragmentFavourites mFragFavourites;
        private FragmentConverter mFragConverter;

        public YourPagerAdapter() {

            // ... your code above
            this.mFragFavourites = new FragmentFavourites();
            this.mFragConverter = new FragmentConverter();
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:  
                    return mFragFavourites;

                case 1:
                    return mFragConverter;                      
                default:
                    return null;
            }    
        }
    }