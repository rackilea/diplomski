private void init()
    {
        {
            ViewContactsFragment fragment = new ViewContactsFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, fragment);//not R.id.fragment_container
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }