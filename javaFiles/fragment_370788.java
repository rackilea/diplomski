Fragment fragment = new ProductListFragment();
FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
FragmentTransaction ft = fragmentManager.beginTransaction();
ft.addToBackStack(null);
ft.replace(R.id.content, fragment);
ft.commit();