public void loadFragment(int id, Fragment fragment) {
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(id, fragment, fragment.toString());
    ft.addToBackStack(null);
    ft.commit();
}