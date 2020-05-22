public static class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
        // ...other cases
        case PEN:
            fragment = PenaltiesFragment.newInstance();
            break;
        // ...other cases
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 6;
    }
}