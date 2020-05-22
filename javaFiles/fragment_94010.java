yourFragment yourFrag = (YourFragment)getSupportFragmentManager().findFragmentById(R.id.your_fragment);

if (yourFrag == null) {
    YourFragment newFragment = new YourFragment();
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.fragment_container, YourFragment);
    transaction.addToBackStack(null);
    transaction.commit();
}