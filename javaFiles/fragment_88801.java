private final List<Fragment> M_FRAGMENT_LIST = new ArrayList<>();
private final List<String> M_FRAGMENT_TITLE = new ArrayList<>();

public SectionsPagerAdapter(FragmentManager fm) {
    super(fm);
}

public void addFragment(Fragment fragment, String title){
    M_FRAGMENT_LIST.add(fragment);
    M_FRAGMENT_TITLE.add(title);
}

@Override
public Fragment getItem(int position) {
    return M_FRAGMENT_LIST.get(position);
}

@Override
public CharSequence getPageTitle(int position) {
    return M_FRAGMENT_TITLE.get(position);
}

@Override
public int getCount() {
    return M_FRAGMENT_LIST.size();
}