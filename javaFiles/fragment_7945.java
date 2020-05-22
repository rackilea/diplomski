Row_main fragment = new Row_main();
FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
fragmentTransaction.replace(R.id.fragment_container, fragment);
fragmentTransaction.addToBackStack(null);
fragmentTransaction.commit();
getActionBar().setTitle("Row");