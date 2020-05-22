private void showFragment(String fragmentId) {
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragmentId);
    if (fragment == null) {
        if (fragmentId.equals("Type1") {
            fragment = Type1Fragment.newInstance();
        }else if (fragmentId.equals("Type2") {
            fragment = Type2Fragment.newInstance();
        }
        ft.replace(R.id.container, fragment, fragmentId).commit();
    }
}