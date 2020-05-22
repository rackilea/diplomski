MapFragment= ((MapFragment) getChildFragmentManager().findFragmentById(R.id.map2));

    MapFragment.getMapAsync(new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {

        }
    });