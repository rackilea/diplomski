@Override
public Fragment getItem(int position) {
    String id = tabs.get(position);
    Fragment fragment = null;
    Bundle args = new Bundle();
    if (id.equals(CUSTOMER_DETAILS_PAGE)) {
        fragment = new UserDetailFragment();
    args.putString("TAG", CUSTOMER_DETAILS_PAGE);
...

@Override
public CharSequence getPageTitle(int position) {
    Locale l = Locale.getDefault();
    String id = tabs.get(position);

     if (id.equals(CUSTOMER_DETAILS_PAGE)) {
        return _ctx.getString(R.string.title_section1).toUpperCase(l);
...