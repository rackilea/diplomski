public class MyPagerAdapter extends FragmentStatePagerAdapter {
    SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return ...;
    }

    @Override
    public Fragment getItem(int position) {
        return MyFragment.newInstance(...); 
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public List<Fragment> getAllFragments() {
        List<Fragment> list = new List<Fragment>();

        for(int i = 0; i < sparseArray.size(); i++) {
           int key = sparseArray.keyAt(i);
           // get the object by the key.
           list.add(sparseArray.get(key));
        }

        return list;
    }
}