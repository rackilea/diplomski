private void setupViewPager(ViewPager viewPager) {
        adapter.addFragment(new ListPdvTabFragment(), "Lista");
        //Add mMapaFragment as a member of the activity
        mMapaFragment = new Fragment();
        adapter.addFragment(mMapaFragment, "Mapa");
        viewPager.setAdapter(adapter);
    }