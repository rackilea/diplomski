protected Fragment openActivity(int position) {

        mDrawerLayout.closeDrawer(mDrawerList);
        Fragment fragment = null;

        switch (position) {
            case 0:{
                fragment =  new SearchActivity();
                break;
            }
            case 1:{
                fragment = new A();
                break;
            }

            case 2:{
                fragment = new B();
                break;
            }

            case 3: {
                fragment = new C();
                break;
            }
            case 4:{
                fragment = new D();
                break;
            }

        }
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, fragment).commit();
        return fragment;
    }