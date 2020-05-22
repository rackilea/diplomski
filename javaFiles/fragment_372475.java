class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (menuItem.getItemId()) {
            case R.id.navigation_menu1:
                transaction.replace(R.id.frame_home, menu1Fragment).commitAllowingStateLoss();
                break;
            case R.id.navigation_menu2:
                transaction.replace(R.id.frame_home, menu2Fragment).commitAllowingStateLoss();
                break;
            case R.id.navigation_menu3:
                transaction.replace(R.id.frame_home, menu3Fragment).commitAllowingStateLoss();
                break;
            case R.id.navigation_menu4:
                transaction.replace(R.id.frame_home, menu4Fragment).commitAllowingStateLoss();
                break;
        }
        return true;
    }
}