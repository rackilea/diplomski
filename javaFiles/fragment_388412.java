// Create new fragment and transaction
Fragment newFragment = new ExampleFragment();
FragmentTransaction transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment
transaction.replace(R.id.fragment_container, newFragment);

// Commit the transaction
transaction.commit();