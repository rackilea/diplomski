switch (position) {
        case 0:
            HomeFragment fragment = new HomeFragment();

            if (fragment != null) {
                  FragmentManager fragmentManager = getSupportFragmentManager();
                  fragmentManager.beginTransaction()
                            .replace(R.id.frame_container, fragment).commit();

                  // update selected item and title, then close the drawer
                  mDrawerList.setItemChecked(position, true);
                  mDrawerList.setSelection(position);
                  setTitle(navMenuTitles[position]);
                  mDrawerLayout.closeDrawer(mDrawerList);
            } else {
                  // error in creating fragment
                  Log.e("MainActivity", "Error in creating fragment");
            }
            break;

            // do like this for remaining cases

        default:
            break;
        }