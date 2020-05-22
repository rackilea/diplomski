private void setUpMapIfNeeded() {
        if (mMap != null) {
            return;
        }
       mMap = new MapFragment();
        mMap.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction()
                .add(R.id.map_fragment, mMap).commit();
    }