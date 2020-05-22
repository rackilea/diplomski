Fragment newFragment = new ColorChangeFragment();
FragmentTransaction transaction = getFragmentManager().beginTransaction();
// Replace whatever is in the container view with this fragment,
// and add the transaction to the back stack
transaction.replace (R.id.container , newFragment);
transaction.addToBackStack(null);
// Commit the transaction
transaction.commit ();