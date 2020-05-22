if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state, 
            // then we don't need to do anything and should return or else 
            // we could end up with overlapping fragments. 
            if (savedInstanceState != null) {
                return; 
            } 

            UserListFragment fragment = new UserListFragment();

            FragmentManager fragmentManager = getSupportFragmentManager(); 
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); 
            fragmentTransaction.add(R.id.fragment_container, fragment, "");
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN); 
            fragmentTransaction.commit(); 
        }