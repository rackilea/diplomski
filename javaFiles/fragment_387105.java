// It is best practice to use factory methods to create Fragment instances
final Fragment fragment = StartupFragment.newInstance();

// There are multiple `FragmentManagers`, be sure to always use the right one!
FragmentManager manager = getFragmentManager();

// This starts the `FragmentTransaction`.
FragmentTransaction transaction = manager.beginTransaction();

// Now you can define what happens in this transactions
// You can add/replace/remove/hide or show as many Fragments 
// as you want in one `FragmentTransaction`.
// This command specifically adds the Fragment to the placeholder we defined
// in the layout of the Activity
transaction.replace(R.id.flFragmentPlaceHolder, fragment);

// This commits the `FragmentTransaction`.
// Only after you call this will any changes be made
transaction.commit();