if (savedInstanceState == null) {
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    ConfigureFragment fragment = new ConfigureFragment();
    fragment.setReferences(MainActivity.this, (Controller) spinner.getSelectedItem());
    fragmentTransaction.add(fragmentView.getId(), fragment, "");
    fragmentTransaction.commit();
}