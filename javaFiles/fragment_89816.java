tabLayout_bookmarks.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(final TabLayout.Tab tab) {
            //let the instantiateItem have some time to be called by the adapter

            currentFragmentIndex = tab.getPosition();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    ViewPagerLifeCycleManagerInterface currentFragment = (ViewPagerLifeCycleManagerInterface)btca.getFragmentAtGivenPosition(tab.getPosition());

                    if(currentFragment!=null){
                        currentFragment.onResumeAndShowFragment();
                    }else{
                        //Log.d("FragmentCreate","Current fragment is null and fucked up in adapter");

                        //if it is null ... that means the adapter hasn't yet called instantiate item ... this internally calls get item any way
                        //.....

                        //This shouldn't really hit but in case it does ... keep a handler in order to ensure that everything is created
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ViewPagerLifeCycleManagerInterface localFragment  = (ViewPagerLifeCycleManagerInterface)btca.getItem(tab.getPosition());
                                //getItem never returns a null fragment unless supplied a horrendous value for position
                                //by the time these 50 ms pass, the instantiate item should surely have been called
                                //else it will be an empty space ... no crash though
                                localFragment.onResumeAndShowFragment();
                            }
                        },50);
                    }

                }
            },100);

        }

        @Override
        public void onTabUnselected(final TabLayout.Tab tab) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ViewPagerLifeCycleManagerInterface currentFragment = (ViewPagerLifeCycleManagerInterface)btca.getFragmentAtGivenPosition(tab.getPosition());
                    if(currentFragment!=null){
                        currentFragment.onPauseAndHideFragment();
                    }else{
                        //Log.d("FragmentCreateTab","the fucking fragment was null");
                        //if it is null ... that means the adapter hasn't yet called instantiate item ... this internally calls get item any way
                        //.....

                        //This shouldn't really hit but in case it does ... keep a handler in order to ensure that everything is created
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ViewPagerLifeCycleManagerInterface localFragment  = (ViewPagerLifeCycleManagerInterface)btca.getItem(tab.getPosition());
                                //getItem never returns a null fragment unless supplied a horrendous value for position
                                //by the time these 50 ms pass, the instantiate item should surely have been called
                                //else it will be an empty space ... no crash though
                                localFragment.onPauseAndHideFragment();
                            }
                        },50);

                    }

                }
            },100);
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
            //do nothing
        }
    });