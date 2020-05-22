public void selectDrawerItem(MenuItem menuItem) {
    ...
    try {
        fragment = (Fragment) fragmentClass.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        ...
        if (ScreenOne.class.equals(fragmentClass)) {
            fragment.loadText();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}