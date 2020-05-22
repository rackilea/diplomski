public class MyActivity extends Activity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    public onCreate(...) {
        MyFrament myFragment = new MyFragment(this);
        // Add fragment to Viewpager ...
        // Attach ViewPager to TabLayout ...
    }

    public void switchTab(int index) {
        // Check index ...
        mViewPager.setCurrentItem(index);
    }
}