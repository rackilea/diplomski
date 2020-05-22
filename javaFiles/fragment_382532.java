FragmentTransaction fragmentTransaction = getSupportFragmentManager()
        .beginTransaction();
Fragment profileFragment = new HomeFragment();//the fragment you want to show
fragmentTransaction
        .add(R.id.parent, profileFragment);//R.id.content_frame is the layout you want to replace
fragmentTransaction.commit();