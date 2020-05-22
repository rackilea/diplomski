public class HomeViewPagerAdapter extends FragmentPagerAdapter {

    public static final int FRAGMENT_A_INDEX = 0;
    public static final int FRAGMENT_B_INDEX = 1;
    public static final int FRAGMENT_C_INDEX = 2;

    public static final int FRAGMENTS_COUNT = 3;

    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case FRAGMENT_A_INDEX:
                return FragmentA.newInstance();
            case FRAGMENT_B_INDEX:
                return FragmentB.newInstance();
            case FRAGMENT_C_INDEX:
                return FragmentC.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return FRAGMENTS_COUNT;
    }
}