String fragmentName = targetFragment.getClass().getName();
FragmentManager manager = getSupportFragmentManager();
Fragment targetFragment = new MainActivityFragment();
manager.popBackStack();
manager.beginTransaction()
                .replace(R.id.main_fragment, targetFragment, fragmentName)
                .addToBackStack(fragmentName)
                .commit();