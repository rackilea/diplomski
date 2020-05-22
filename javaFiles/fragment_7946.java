public void transitionFragment(Fragment fragment, Bundle arguments, String title) { 

    getSupportActionBar().setTitle(title);

    if (arguments != null) fragment.setArguments(arguments);

    getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit();
}