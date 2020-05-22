DetailViewFragment detailFragment = new DetailViewFragment();
Bundle args = new Bundle();
args.putString(DetailViewFragment.INIT_URL, URL);
detailFragment.setArguments(args);
ft.replace(R.id.displayList, detailFragment);
ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
ft.addToBackStack(null);
ft.commit();