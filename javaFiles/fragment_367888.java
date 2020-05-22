Fragment fragment;
 //choose the fragment from intent data
 fragment = createFragmentFromIntent(intent);


 FragmentManager fragmentManager = getChildFragmentManager();
 FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
 fragmentTransaction.replace(example_id, fragment);
 fragmentTransaction.commitAllowingStateLoss();