public class FragmentAdapter extends FragmentPagerAdapter{
      private List<Fragment> fragments;

      public FragmentAdapter (FragmentManager fm, List<Fragment> fragments) {
          super(fm);
              this.fragments = fragments;
      }

      @Override
      public Fragment getItem(int position) {
          return this.fragments.get(position);
      }

      @Override
      public void destroyItem (ViewGroup container, int position, Object object)
      {
          super.destroyItem(container, position, object);
      }

      @Override
      public int getCount() {
         return this.fragments.size();
      }
 }