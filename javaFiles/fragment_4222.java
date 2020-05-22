private void displayView(int position) {
        //Fragment fragment = null;  ---Removed for test, because if I don't remove this line couldn't execute the app because fragment can not call a FragmentActivity....

    if(position == 0){

        mDrawerList.setItemChecked(position, true);
        mDrawerList.setSelection(position);
        setTitle(navMenuTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
        Intent intent = new Intent(MainActivity.this, TabHostFragment.class);
        startActivity(intent);
    }
    else
    {
        Fragment fragment = null;

        switch (position) {
        case 1:
            fragment = new RecomendacionesFragment();
            break;
        case 2:
            fragment = new LocalizacionFragment();
            break;
        case 3:
            fragment = new ListaProductosFragment();
            break;
        case 4:
            fragment = new ConfiguracionFragment();
            break;
        case 5:
            fragment = new AyudaSugerenciasFragment();
            break;
            case 6:
                fragment = new AyudaSugerencias();
                break;

            default:
            break;
         }


            if (fragment != null) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment).commit(); /// here says that replace android.app.Fragment in FragmentTransaction cannot be applied...

                // update selected item and title, then close the drawer
                mDrawerList.setItemChecked(position, true);
                mDrawerList.setSelection(position);
                setTitle(navMenuTitles[position]);
                mDrawerLayout.closeDrawer(mDrawerList);
            } else {
                // error in creating fragment
                Log.e("MainActivity", "Error in creating fragment");
            }
        }
        }
    }