FragmentManager fManager= getChildFragmentManager();
mapFragment = (SupportMapFragment) fManager
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    if (googleMap == null) {
                        Log.d("MAPA_FRAGMENT", "Sorry! unable to create maps");
                    } else {
                        mMap = googleMap;
                    }
                }
            });