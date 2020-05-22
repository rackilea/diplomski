Fragment fragment = new StaticContent();
Bundle bundle = new Bundle();
bundle.putString("Key", "Value");
fragment.setArguments(bundle);
FragmentManager fragmentManager = getSupportFragmentManager();
fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(null).commitAllowingStateLoss();
fragmentManager.executePendingTransactions();