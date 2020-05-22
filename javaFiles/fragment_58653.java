public class ViewPagerAdapter extends FragmentPagerAdapter {
private final List<Fragment> mFragmentList = new ArrayList<>();

public ViewPagerAdapter(FragmentManager manager) {
    super(manager);
}
@Override
public Fragment getItem(int position) {
    return mFragmentList.get(position);
}

@Override
public int getCount() {
    return mFragmentList.size();
}

public void addFragment(Fragment fragment) {
    mFragmentList.add(fragment);
}

}